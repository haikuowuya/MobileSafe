package com.lilosoft.xtcm.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lilosoft.xtcm.utils.LogFactory;

public class BootBroadcastReceiver extends BroadcastReceiver {
	// ��дonReceive����
	@Override
	public void onReceive(Context context, Intent intent) {
		Intent service = new Intent(
				"COM.LILOSOFT.XTCM.MODULE.AUTO_LOCATION_REPORT_SERVICE");
		context.startService(service);
		LogFactory.v("�ǹ�ͨ", "�Զ�����");
		// ����Ӧ�ã�����Ϊ��Ҫ�Զ�������Ӧ�õİ���
	}
}
