package com.lilosoft.xtcm.utils;

import org.json.JSONException;

/**
 * @category json���ݴ���
 * @author William Liu
 */
public interface JsonParseInterface {

	/**
	 * @category ����������ָ���
	 * @return
	 */
	abstract int jsonParseToOrder(String response) throws JSONException;

}
