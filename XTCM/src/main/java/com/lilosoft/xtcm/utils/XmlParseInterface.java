package com.lilosoft.xtcm.utils;

import org.json.JSONException;

/**
 * @category XML���ݴ���
 * @author William Liu
 */
public interface XmlParseInterface {

	/**
	 * @category ����������ָ���
	 * @return
	 */
	abstract int xmlParseToOrder(String response) throws JSONException;

}
