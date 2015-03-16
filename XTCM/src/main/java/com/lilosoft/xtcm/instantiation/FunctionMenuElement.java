package com.lilosoft.xtcm.instantiation;

import android.content.Intent;

/**
 * @category �˵�Ԫ��
 * @author William Liu
 * 
 */

public class FunctionMenuElement {

	/**
	 * @category ��־λ
	 */
	private String tag;
	/**
	 * @category �ֶ���
	 */
	private int resLabel;
	/**
	 * @category ͼ��
	 */
	private int resIcon;
	/**
	 * @category ��Ӧ�¼�
	 */
	private Intent content;

	/**
	 * @category �˵�Ԫ�ع��췽��
	 * @param tag
	 * @param resLabel
	 * @param resIcon
	 * @param content
	 */
	public FunctionMenuElement(String tag, int resLabel, int resIcon,
			Intent content) {
		this.tag = tag;
		this.resLabel = resLabel;
		this.resIcon = resIcon;
		this.content = content;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getResLabel() {
		return resLabel;
	}

	public void setResLabel(int resLabel) {
		this.resLabel = resLabel;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Intent getContent() {
		return content;
	}

	public void setContent(Intent content) {
		this.content = content;
	}

}
