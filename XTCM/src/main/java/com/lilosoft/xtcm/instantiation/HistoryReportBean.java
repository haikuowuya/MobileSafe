package com.lilosoft.xtcm.instantiation;

import java.util.ArrayList;
import java.util.List;

/**
 * @category ��ʷ���ϱ��ֶ�
 * @author William Liu
 * 
 */
public class HistoryReportBean {

	private List<String> list = null;
	private String DISPATCHWARMINGTIME; // ��ǲԤ��ʱ��
	private String CASEITEM; // ��ȡ�����ķ���
	private String CASECODE; // �������
	private String CASEDESCRIPTION; // ��������
	private String CASESOURCE; // ������Դ
	private String CASETITLE; // �������
	private String SIGNTIME; // ǩ��ʱ��
	private String GRIDCODE; // ������
	private String CREATETIME; // ��������ʱ��
	private String PUTONRECORDWARNINGTIME; // ����Ԥ��ʱ��
	private String PUTONRECORDTIME; // ����ʱ��
	private String DeptName; // ���ò���
	private String FEEDBACKDEALRESULT; // ����������
	private List<FileBean> ApproveFileList;

	public HistoryReportBean(String dispatchwarmingtime, String caseitem,
			String casecode, String casedescription, String casesource,
			String casetitle, String signtime, String gridcode,
			String createtime, String putonrecordwarningtime,
			String putonrecordtime, String deptname, String feedbackdealresult,
			List<FileBean> approvefilelist) {
		// TODO Auto-generated constructor stub
		this.DISPATCHWARMINGTIME = dispatchwarmingtime;
		this.CASEITEM = caseitem;
		this.CASECODE = casecode;
		this.CASEDESCRIPTION = casedescription;
		this.CASESOURCE = casesource;
		this.CASETITLE = casetitle;
		this.SIGNTIME = signtime;
		this.GRIDCODE = gridcode;
		this.CREATETIME = createtime;
		this.PUTONRECORDWARNINGTIME = putonrecordwarningtime;
		this.PUTONRECORDTIME = putonrecordtime;
		this.DeptName = deptname;
		this.FEEDBACKDEALRESULT = feedbackdealresult;
		this.ApproveFileList = approvefilelist;
		setList();

	}

	public List<String> getList() {
		return list;
	}

	public void setList() {

		if (null != CASECODE) {
			list = new ArrayList<String>();
			list.add("��ǲԤ��ʱ��:");
			list.add(DISPATCHWARMINGTIME);
			list.add("��ȡ�����ķ���:");
			list.add(CASEITEM);
			list.add("�������:");
			list.add(CASECODE);
			list.add("��������:");
			list.add(CASEDESCRIPTION);
			list.add("������Դ:");
			list.add(CASESOURCE);
			list.add("�������:");
			list.add(CASETITLE);
			list.add("ǩ��ʱ��:");
			list.add(SIGNTIME);
			list.add("������:");
			list.add(GRIDCODE);
			list.add("��������ʱ��:");
			list.add(CREATETIME);
			list.add("����Ԥ��ʱ��:");
			list.add(PUTONRECORDWARNINGTIME);
			list.add("����ʱ��:");
			list.add(PUTONRECORDTIME);
			list.add("���ò���:");
			list.add(DeptName);
			list.add("����������:");
			list.add(FEEDBACKDEALRESULT);
		}

	}

	public String getDISPATCHWARMINGTIME() {
		return DISPATCHWARMINGTIME;
	}

	public void setDISPATCHWARMINGTIME(String dISPATCHWARMINGTIME) {
		DISPATCHWARMINGTIME = dISPATCHWARMINGTIME;
	}

	public String getCASEITEM() {
		return CASEITEM;
	}

	public void setCASEITEM(String cASEITEM) {
		CASEITEM = cASEITEM;
	}

	public String getCASECODE() {
		return CASECODE;
	}

	public void setCASECODE(String cASECODE) {
		CASECODE = cASECODE;
	}

	public String getCASEDESCRIPTION() {
		return CASEDESCRIPTION;
	}

	public void setCASEDESCRIPTION(String cASEDESCRIPTION) {
		CASEDESCRIPTION = cASEDESCRIPTION;
	}

	public String getCASESOURCE() {
		return CASESOURCE;
	}

	public void setCASESOURCE(String cASESOURCE) {
		CASESOURCE = cASESOURCE;
	}

	public String getCASETITLE() {
		return CASETITLE;
	}

	public void setCASETITLE(String cASETITLE) {
		CASETITLE = cASETITLE;
	}

	public String getSIGNTIME() {
		return SIGNTIME;
	}

	public void setSIGNTIME(String sIGNTIME) {
		SIGNTIME = sIGNTIME;
	}

	public String getGRIDCODE() {
		return GRIDCODE;
	}

	public void setGRIDCODE(String gRIDCODE) {
		GRIDCODE = gRIDCODE;
	}

	public String getCREATETIME() {
		return CREATETIME;
	}

	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}

	public String getPUTONRECORDWARNINGTIME() {
		return PUTONRECORDWARNINGTIME;
	}

	public void setPUTONRECORDWARNINGTIME(String pUTONRECORDWARNINGTIME) {
		PUTONRECORDWARNINGTIME = pUTONRECORDWARNINGTIME;
	}

	public String getPUTONRECORDTIME() {
		return PUTONRECORDTIME;
	}

	public void setPUTONRECORDTIME(String pUTONRECORDTIME) {
		PUTONRECORDTIME = pUTONRECORDTIME;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getFEEDBACKDEALRESULT() {
		return FEEDBACKDEALRESULT;
	}

	public void setFEEDBACKDEALRESULT(String fEEDBACKDEALRESULT) {
		FEEDBACKDEALRESULT = fEEDBACKDEALRESULT;
	}

	public List<FileBean> getApproveFileList() {
		return ApproveFileList;
	}

	public void setApproveFileList(List<FileBean> approveFileList) {
		ApproveFileList = approveFileList;
	}

}
