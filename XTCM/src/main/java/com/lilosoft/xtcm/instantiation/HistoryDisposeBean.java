package com.lilosoft.xtcm.instantiation;

import java.util.ArrayList;
import java.util.List;

/**
 * @category ��ʷ�Ѱ����ֶ�
 * @author William Liu
 * 
 */
public class HistoryDisposeBean {

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
	private String PutonerdUser; // ����������
	private String DeptName; // ���ò���
	private String FEEDBACKDEALRESULT; // ����������
	private String FEEDBACKDEALTIME; // ������ʱ��
	private String ConfrimPerson; // ������
	private List<FileBean> ApproveFileList;
	private List<FileBean> DeptFileList;

	public HistoryDisposeBean(String dispatchwarmingtime, String caseitem,
			String casecode, String casedescription, String casesource,
			String casetitle, String signtime, String gridcode,
			String createtime, String putonrecordwarningtime,
			String putonrecordtime, String putonerduser, String deptname,
			String feedbackdealresult, String feedbackdealtime,
			String confrimperson, List<FileBean> approvefilelist,
			List<FileBean> deptfilelist) {
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
		this.PutonerdUser = putonerduser;
		this.DeptName = deptname;
		this.FEEDBACKDEALRESULT = feedbackdealresult;
		this.FEEDBACKDEALTIME = feedbackdealtime;
		this.ConfrimPerson = confrimperson;
		this.ApproveFileList = approvefilelist;
		this.DeptFileList = deptfilelist;
		setList();
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
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
			list.add("����������:");
			list.add(PutonerdUser);
			list.add("���ò���:");
			list.add(DeptName);
			list.add("����������:");
			list.add(FEEDBACKDEALRESULT);
			list.add("������ʱ��:");
			list.add(FEEDBACKDEALTIME);
			list.add("������:");
			list.add(ConfrimPerson);
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

	public String getPutonerdUser() {
		return PutonerdUser;
	}

	public void setPutonerdUser(String putonerdUser) {
		PutonerdUser = putonerdUser;
	}

	public String getFEEDBACKDEALRESULT() {
		return FEEDBACKDEALRESULT;
	}

	public void setFEEDBACKDEALRESULT(String fEEDBACKDEALRESULT) {
		FEEDBACKDEALRESULT = fEEDBACKDEALRESULT;
	}

	public String getFEEDBACKDEALTIME() {
		return FEEDBACKDEALTIME;
	}

	public void setFEEDBACKDEALTIME(String fEEDBACKDEALTIME) {
		FEEDBACKDEALTIME = fEEDBACKDEALTIME;
	}

	public String getConfrimPerson() {
		return ConfrimPerson;
	}

	public void setConfrimPerson(String confrimPerson) {
		ConfrimPerson = confrimPerson;
	}

	public List<FileBean> getApproveFileList() {
		return ApproveFileList;
	}

	public void setApproveFileList(List<FileBean> approveFileList) {
		ApproveFileList = approveFileList;
	}

	public List<FileBean> getDeptFileList() {
		return DeptFileList;
	}

	public void setDeptFileList(List<FileBean> deptFileList) {
		DeptFileList = deptFileList;
	}

}
