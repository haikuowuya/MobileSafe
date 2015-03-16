package com.lilosoft.xtcm.utils;

import android.util.Log;

import com.lilosoft.xtcm.constant.Config;

/**
 *  @category ��־����
 * @author William Liu
 *
 */
public class LogFactory {

	/**
	 * @category ��־���Token
	 */
	private static final boolean isDebug = !Config.LOGLEVEL;

	/**
	 * @category DEBUG
	 * @param TAG
	 * @param msg
	 */
	public static void d(String TAG, String msg) {
		if (isDebug)
			Log.d(TAG, msg);
	}

	/**
	 * @category ERROR
	 * @param TAG
	 * @param msg
	 */
	public static void e(String tag, String msg) {
		if (isDebug)
			Log.e(tag, msg);
	}

	/**
	 * @category VERBOSE
	 * @param TAG
	 * @param msg
	 */
	public static void v(String tag, String msg) {
		if (isDebug)
			Log.v(tag, msg);
	}

}