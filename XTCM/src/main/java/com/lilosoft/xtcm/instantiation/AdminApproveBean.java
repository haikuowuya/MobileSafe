package com.lilosoft.xtcm.instantiation;

import java.util.ArrayList;
import java.util.List;

public class AdminApproveBean {

	private String ADTIVEID; // �������
	private String ADTIVETITLE; // ��������
	private String ADTIVETYPE; // ��������
	private String ADTIVECONTENT; // ��������
	private String ADTIVEDATA; // ����ʱ��
	private String RN;
	private List<String> list = null;

	public AdminApproveBean(String adtiveid, // �������
			String adtivetitle, // ��������
			String adtivetype, // ��������
			String adtivecontent, // ��������
			String adtivedata, // ����ʱ��
			String rn) {
		// TODO Auto-generated constructor stub
		this.ADTIVEID = adtiveid; // �������
		this.ADTIVETITLE = adtivetitle; // ��������
		this.ADTIVETYPE = adtivetype; // ��������
		this.ADTIVECONTENT = adtivecontent; // ��������
		this.ADTIVEDATA = adtivedata;
		this.RN = rn;
		setList();
	}

	public String getADTIVEID() {
		return ADTIVEID;
	}

	public void setADTIVEID(String aDTIVEID) {
		ADTIVEID = aDTIVEID;
	}

	public String getADTIVETITLE() {
		return ADTIVETITLE;
	}

	public void setADTIVETITLE(String aDTIVETITLE) {
		ADTIVETITLE = aDTIVETITLE;
	}

	public String getADTIVETYPE() {
		return ADTIVETYPE;
	}

	public void setADTIVETYPE(String aDTIVETYPE) {
		ADTIVETYPE = aDTIVETYPE;
	}

	public String getADTIVECONTENT() {
		return ADTIVECONTENT;
	}

	public void setADTIVECONTENT(String aDTIVECONTENT) {
		ADTIVECONTENT = aDTIVECONTENT;
	}

	public String getADTIVEDATA() {
		return ADTIVEDATA;
	}

	public void setADTIVEDATA(String aDTIVEDATA) {
		ADTIVEDATA = aDTIVEDATA;
	}

	public String getRN() {
		return RN;
	}

	public void setRN(String rN) {
		RN = rN;
	}
	
	public List<String> getList() {
		return list;
	}

	public void setList() {

		if (null != ADTIVEID) {
			list = new ArrayList<String>();
//			list.add("�������:");
//			list.add(ADTIVEID);
			list.add("��������:");
			list.add(ADTIVETYPE);
			list.add("����ʱ��:");
			list.add(ADTIVEDATA);
			list.add("��������:");
			list.add(ADTIVETITLE);
			list.add("��������:");
			list.add(ADTIVECONTENT);
		}

	}

}
