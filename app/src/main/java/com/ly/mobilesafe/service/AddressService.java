package com.ly.mobilesafe.service;

import com.ly.mobilesafe.R;
import com.ly.mobilesafe.dao.NumberAddressQueryUtils;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class AddressService extends Service {

    /**
     * 窗体管理者
     */
    private WindowManager wm;
    private View view;

    private SharedPreferences sp;
    //电话服务
    private TelephonyManager tm;
    private MyListenerPhone listenerPhone;

    private OutCallReceiver receiver;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        //监听来电
        listenerPhone = new MyListenerPhone();
        tm.listen(listenerPhone, PhoneStateListener.LISTEN_CALL_STATE);
        //用代码去注册广播接收者
        receiver = new OutCallReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        registerReceiver(receiver, filter);

        //实例化窗体
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消监听来电
        tm.listen(listenerPhone, PhoneStateListener.LISTEN_NONE);
        tm = null;
        //用代码取消注册广播接收者
        unregisterReceiver(receiver);
        receiver = null;
    }

    long[] mHits = new long[2];
    /**
     * 自定义土司
     * @param address
     */
    public void myToast(String address)
    {
        //设置窗体参数
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();

        view = View.inflate(this,R.layout.address_show, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_address);
        //双击控件居中显示
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                System.arraycopy(mHits, 1, mHits, 0, mHits.length-1);
                mHits[mHits.length-1] = SystemClock.uptimeMillis();
                if(mHits[0]>=(SystemClock.uptimeMillis()-500))
                {
                    params.x = wm.getDefaultDisplay().getWidth()/2 - view.getWidth()/2;
                    wm.updateViewLayout(view, params);
                    Editor editor = sp.edit();
                    editor.putInt("lastx", params.x);
                    //editor.putInt("lasty", params.y);
                    editor.commit();
                }
            }
        });

        //给view对象设置一个触摸的监听器
        view.setOnTouchListener(new OnTouchListener() {
            //定义手指的初始化位置
            int startX;
            int startY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getRawX();
                        startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int newX = (int) event.getRawX();
                        int newY = (int) event.getRawY();
                        int dx = newX - startX;
                        int dy = newY - startY;
                        params.x += dx;
                        params.y += dy;
                        //考虑边界问题
                        if(params.x<0)
                        {
                            params.x = 0;
                        }
                        if(params.y<0)
                        {
                            params.y = 0;
                        }
                        if(params.x > (wm.getDefaultDisplay().getWidth()-view.getWidth()))
                        {
                            params.x = wm.getDefaultDisplay().getWidth() - view.getWidth();
                        }
                        if(params.y > (wm.getDefaultDisplay().getHeight()-view.getHeight()))
                        {
                            params.y = wm.getDefaultDisplay().getHeight() - view.getHeight();
                        }
                        wm.updateViewLayout(view, params);
                        startX = (int) event.getRawX();
                        startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                        Editor editor = sp.edit();
                        editor.putInt("lastx", params.x);
                        editor.putInt("lasty", params.y);
                        editor.commit();
                        break;
                }
                return false;
            }
        });
        //"半透明","活力橙","卫士蓝","金属灰","苹果绿"
        int [] ids = {R.drawable.call_locate_white,R.drawable.call_locate_orange,R.drawable.call_locate_blue
                ,R.drawable.call_locate_gray,R.drawable.call_locate_green};
        sp = getSharedPreferences("config", MODE_PRIVATE);
        view.setBackgroundResource(ids[sp.getInt("which", 0)]);
        textView.setText(address);


        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        // 与窗体左上角对其
        params.gravity = Gravity.TOP + Gravity.LEFT;
        // 指定窗体距离左边100 上边100个像素
        params.x = sp.getInt("lastx", 0);
        params.y = sp.getInt("lasty", 0);
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                |WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        params.format = PixelFormat.TRANSLUCENT; //设置为半透明
        params.type = WindowManager.LayoutParams.TYPE_PRIORITY_PHONE;
        wm.addView(view, params);
    }

    private class MyListenerPhone extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            //state:状态，incomingNumber:来电号码
            super.onCallStateChanged(state, incomingNumber);
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING: //来电铃声响起
                    //查询数据的操作
                    String address = NumberAddressQueryUtils.queryNumber(incomingNumber);
                    //Toast.makeText(getApplicationContext(), address, 1).show();
                    myToast(address);
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    //电话的空闲状态：挂电话，来电拒绝
                    if(view!=null)
                    {
                        wm.removeView(view);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    class OutCallReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String phone = getResultData();
            String address = NumberAddressQueryUtils.queryNumber(phone);
            //Toast.makeText(context, address, 1).show();
            myToast(address);
        }

    }
}
