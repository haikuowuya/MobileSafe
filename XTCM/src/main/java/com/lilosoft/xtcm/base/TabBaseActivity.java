package com.lilosoft.xtcm.base;

import android.view.KeyEvent;

import com.lilosoft.xtcm.constant.Config;

public abstract class TabBaseActivity extends NormalBaseActivity {
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		initListView();
	}

	/**
	 * @category ��ʼ���б�
	 */
	protected abstract void initListView();

	/**
	 * @category back�¼�
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (KeyEvent.KEYCODE_BACK == keyCode) {
			HomeBaseActivity.tabHost.setCurrentTabByTag(Config.A_TAB);
			HomeBaseActivity.tabBt1.setChecked(true);
		}

		return false;
		
	}

}
