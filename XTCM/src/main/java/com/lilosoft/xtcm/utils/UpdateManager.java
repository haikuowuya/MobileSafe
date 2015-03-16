package com.lilosoft.xtcm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.lilosoft.xtcm.R;
import com.lilosoft.xtcm.constant.Config;

public class UpdateManager {

    /* ������ */
    private static final int DOWNLOAD = 1;
    /* ���ؽ��� */
    private static final int DOWNLOAD_FINISH = 2;
    private static final int UPDATE_APK = 3;
    private static final int NOUPDATE_APK = 4;
    private static final int LOSTCONNECT = 5;
    public static boolean isupdateMananger;//�Ƿ���³���
    /* ���������XML��Ϣ */
    HashMap<String, String> mHashMap;
    /* ���ر���·�� */
    private String mSavePath;
    /* ��¼���������� */
    private int progress;
    private Handler mHandler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                // ��������
                case DOWNLOAD:
                    // ���ý�����λ��
                    mProgress.setProgress(progress);
                    break;
                case DOWNLOAD_FINISH:
                    // ��װ�ļ�
                    installApk();
                    break;

                case UPDATE_APK:
                    showNoticeDialog();
                    break;
                default:
                    break;
            }
        };
    };
    /* �Ƿ�ȡ������ */
    private boolean cancelUpdate = false;
    private Context mContext;
    /* ���½����� */
    private ProgressBar mProgress;

//	private ProgressDialog prodialog;
//	
//	private Dialog loadingDialog;
    private Dialog mDownloadDialog;

    public UpdateManager(Context context)
    {
        this.mContext = context;
    }

    /**
     * ����������
     */
    public void checkUpdate() {
        isUpdate();
    }

    /**
     * �������Ƿ��и��°汾
     *
     * @return
     */

    private void isUpdate() {
//		if(Methods.NOAUTOUPDATE){
////			prodialog.show();
//			loadingDialog=CallWebUtils.getDialog(mContext);
//		}
        new checkVersionThread().start();
        // ��ȡ��ǰ����汾
    }

    /**
     * ��ȡ����汾��
     *
     * @param context
     * @return
     */
    private int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            // ��ȡ����汾�ţ���ӦAndroidManifest.xml��android:versionCode
            versionCode = context.getPackageManager().getPackageInfo(
                    "com.lilosoft.xtcm", 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * ��ʾ������¶Ի���
     */
    private void showNoticeDialog() {
        // ����Ի���
        AlertDialog.Builder builder = new Builder(mContext);
        builder.setTitle("�������");
        builder.setMessage("��⵽�°汾������������");
        // ����
        builder.setPositiveButton("����", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // �ж�SD���Ƿ���ڣ������Ƿ���ж�дȨ��
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    dialog.dismiss();
                    // ��ʾ���ضԻ���
                    showDownloadDialog();
                } else {
                    // ��ʾSD��û��Ȩ��
                    dialog.dismiss();
                    AlertDialog.Builder builder2 = new Builder(mContext);
                    builder2.setTitle("�������");
                    builder2.setMessage("û��sdcardȨ��,���ܸ��£�");

                    // ����
                    builder2.setNegativeButton("ȷ��", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialoginterface,
                                            int i) {

                            dialoginterface.dismiss();
                        }
                    });
                    Dialog noticeDialog2 = builder2.create();
                    noticeDialog2.show();
                }
            }
        });
        // �Ժ����
        builder.setNegativeButton("�Ժ����", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }

    /**
     * ��ʾ������ضԻ���
     */
    private void showDownloadDialog() {
        // ����������ضԻ���
        AlertDialog.Builder builder = new Builder(mContext);
        builder.setTitle(R.string.soft_updating);
        // �����ضԻ������ӽ�����
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.download_layout, null);
        mProgress = (ProgressBar) v.findViewById(R.id.progress_horizontal);
        builder.setView(v);
        // ȡ������
        builder.setNegativeButton(R.string.soft_update_cancel,
                new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        // ����ȡ��״̬
                        cancelUpdate = true;
                    }
                });
        mDownloadDialog = builder.create();
        mDownloadDialog.setCanceledOnTouchOutside(false);
        mDownloadDialog.show();

        // �����ļ�
        downloadApk();
    }

    /**
     * ����apk�ļ�
     */
    private void downloadApk() {
        // �������߳��������
        new downloadApkThread().start();
    }

    /**
     * ��װAPK�ļ�
     */
    private void installApk() {
        File apkfile = new File(mSavePath, mHashMap.get("name"));
        if (!apkfile.exists()) {
            return;
        }
        // ͨ��Intent��װAPK�ļ�
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()),
                "application/vnd.android.package-archive");
        mContext.startActivity(i);
    }

        private class checkVersionThread extends Thread {
        public void run() {
            int versionCode = getVersionCode(mContext);
            URL u;
            try {
                u = new URL(Config.VERSION_URL);
                InputStream inStream = u.openStream();
                ParseXmlService service = new ParseXmlService();
                mHashMap = service.parseXml(inStream);
                inStream.close();
                if (null != mHashMap) {

                    double serviceCode = Double
                            .valueOf(mHashMap.get("version"));
                    // �汾�ж�
                    if (serviceCode > versionCode) {
                        isupdateMananger=true;
                        mHandler.sendEmptyMessage(UPDATE_APK);
                    } /*else {
							mHandler.sendEmptyMessage(NOUPDATE_APK);
						}*/
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
//					if(Methods.NOAUTOUPDATE){
//						mHandler.sendEmptyMessage(LOSTCONNECT);
//					}
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

/**
     * �����ļ��߳�
     *
     */
    private class downloadApkThread extends Thread {
        @Override
        public void run() {
            try {
                // �ж�SD���Ƿ���ڣ������Ƿ���ж�дȨ��
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    // ��ô洢����·��
                    String sdpath = Environment.getExternalStorageDirectory()
                            + "/";
                    mSavePath = sdpath + "download";
                    URL url = new URL(mHashMap.get("url"));
                    // ��������
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    conn.connect();
                    // ��ȡ�ļ���С
                    int length = conn.getContentLength();
                    // ����������
                    InputStream is = conn.getInputStream();
                    File file = new File(mSavePath);
                    // �ж��ļ�Ŀ¼�Ƿ����
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File apkFile = new File(mSavePath, mHashMap.get("name"));
                    Log.e("sdk", mSavePath);
                    FileOutputStream fos = new FileOutputStream(apkFile);
                    int count = 0;
                    // ����
                    byte buf[] = new byte[1024];
                    // д�뵽�ļ���
                    do {
                        int numread = is.read(buf);
                        count += numread;
                        // ���������λ��
                        progress = (int) (((float) count / length) * 100);
                        // ���½���
                        mHandler.sendEmptyMessage(DOWNLOAD);
                        if (numread <= 0) {
                            // �������
                            mHandler.sendEmptyMessage(DOWNLOAD_FINISH);
                            break;
                        }
                        // д���ļ�
                        fos.write(buf, 0, numread);
                    } while (!cancelUpdate);// ���ȡ����ֹͣ����.
                    fos.close();
                    is.close();
                }
            } catch (Exception e) {
                // ��ʾx
                e.printStackTrace();
            }
            // ȡ�����ضԻ�����ʾ
            mDownloadDialog.dismiss();
        }
    }

}
