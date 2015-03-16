package com.lilosoft.xtcm.module;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

import com.lilosoft.xtcm.constant.Config;
import com.lilosoft.xtcm.database.SharedPreferencesFactory;
import com.lilosoft.xtcm.instantiation.User;
import com.lilosoft.xtcm.network.HttpConnection;
import com.lilosoft.xtcm.utils.LogFactory;

/**
 * @category �ϱ��켣����
 * @author William Liu
 * 
 */
public class AutoLocationReportService extends Service {

	private final String TAG = "AutoLocationReportService";
	Thread thread = null;
	private LocationManager locationManager;
	private boolean localPass = true;
	private double latitude = 0.0;
	private double longitude = 0.0;
	Thread submitLocal = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				HttpConnection httpConnection = new HttpConnection();
				httpConnection.getData(
						HttpConnection.CONNECTION_LOCATION_REPORT,
						User.username, "GridOfficer", longitude + "", latitude
								+ "");
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});
	Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			getLocation();
			if (0 != latitude && 0 != longitude && localPass) {
				localPass = false;
				if (Config.NETWORK) {
					LogFactory.e(TAG, "��ǰ�켣Ϊ:"+latitude+longitude);
					thread = new Thread(submitLocal);
					thread.start();
				}
			} else {
				LogFactory.e(TAG, "û�л�ȡ����ַ!");
			}

		};
	};
	LocationListener locationListener = new LocationListener() {

		// Provider��״̬�ڿ��á���ʱ�����ú��޷�������״ֱ̬���л�ʱ�����˺���
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {

		}

		// Provider��enableʱ�����˺���������GPS����
		@Override
		public void onProviderEnabled(String provider) {

		}

		// Provider��disableʱ�����˺���������GPS���ر�
		@Override
		public void onProviderDisabled(String provider) {

		}

		// ������ı�ʱ�����˺��������Provider������ͬ�����꣬���Ͳ��ᱻ����
		@Override
		public void onLocationChanged(Location location) {
			if (location != null) {
				latitude = location.getLatitude(); // ����
				longitude = location.getLongitude(); // γ��
				localPass = true;
			}
		}
	};

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		LogFactory.e(TAG, "���񴴽�");
		if ("" == User.username)
			try {
				User.username = new SharedPreferencesFactory().getTopUser(
						createPackageContext("com.lilosoft.xtcm",
								Context.CONTEXT_INCLUDE_CODE
										| Context.CONTEXT_IGNORE_SECURITY))
						.getUsername();
				MyTimerTask timerTask = new MyTimerTask();
				Timer timer = new Timer(true);
				timer.schedule(timerTask, 0, Config.AUTO_LOCATION_REPORT_TIME);
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else {
			MyTimerTask timerTask = new MyTimerTask();
			Timer timer = new Timer(true);
			timer.schedule(timerTask, 0, Config.AUTO_LOCATION_REPORT_TIME);
		}

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		LogFactory.e(TAG, "����ʼ");
		return super.onStartCommand(intent, START_STICKY, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		LogFactory.e(TAG, "����ɱ");
		startService(new Intent(
				"COM.LILOSOFT.XTCM.MODULE.AUTO_LOCATION_REPORT_SERVICE"));
	}

	private void getLocation() {
		if (null == locationManager)
			locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

			locationManager.requestLocationUpdates(
					LocationManager.GPS_PROVIDER, 5000, 0, locationListener);
			Location location = locationManager
					.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

			if (location != null) {
				latitude = location.getLatitude(); // ����
				longitude = location.getLongitude(); // γ��
			}

		} else {

			locationManager
					.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
							5000, 0, locationListener);
			Location location = locationManager
					.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

			if (location != null) {
				latitude = location.getLatitude(); // ����
				longitude = location.getLongitude(); // γ��
			}
		}

	}

	private class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			handler.sendEmptyMessage(0);
		}
	}

}
