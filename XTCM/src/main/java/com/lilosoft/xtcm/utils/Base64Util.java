package com.lilosoft.xtcm.utils;

import android.util.Base64;

/**
 * @category Base64 ���ܹ����� 
 * @author William Liu
 * 
 */
public class Base64Util {

	/**
	 * ����
	 * 
	 * @param data
	 * @return
	 */
	public String enBese64(byte[] data) {
		LogFactory.e("Base64Util", "enBese64:" + new String(data));
		return "V" + Base64.encodeToString(data, Base64.DEFAULT);

	}

	/**
	 * ����
	 * 
	 * @param data
	 * @return
	 */
	public String deBese64(String data) {
		byte b[] = Base64.decode(data.substring(1, data.length()),
				Base64.DEFAULT);
		String data2 = new String(b);
		LogFactory.e("Base64Util", "deBese64:" + data);
		return data2;
	}

}
