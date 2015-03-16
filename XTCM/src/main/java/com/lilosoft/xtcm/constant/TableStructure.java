package com.lilosoft.xtcm.constant;

/**
 * @category ��ṹ
 * @author William Liu
 * 
 */
public class TableStructure {

	/**
	 * @category ��� json �ֶ��� begin
	 */
	public final static String COVER_HEAD = "head";
	public final static String COVER_BODY = "body";
	/**
	 * ��� json �ֶ��� end
	 */
	// ��
	public final static String PUNCHCARD = "InsertRecord";// ������
	public final static String PUNCHCARD_SETUP = "GetKQconfig";// ������
	public final static String PUNCHCARD_Record = "GetKQRecored";
	public final static String PUNCHCARD_place = "GetPersonKQPlace";
	
	
	
	public final static String pcard_morning_time = "SWSBSJ";
	public final static String pcard_afternoon_time = "ZWSBSJ";
	public final static String pcard_evening_time = "XWXBSJ";
	public final static String pcard_allowlate_time = "YXCDSJ";
	public final static String pcard_allow_leave_time = "YXZTSJ";
	public final static String pcard_gap_time = "DKJGSJ";

	// �ֶ�
	public final static String PCARD_USERNAME = "USERLOGINNAME";
	public final static String PCARD_DATE = "GetRecordDate";
	public final static String PCARD_WORKTIME = "GETRECORDTIME";
	public final static String PCARD_OFFWORKTIME = "OffRecordDate";
	public final static String PCARD_UPTYPE = "UpType";
	public final static String PCARD_OFFTYPE = "OffType";
	public final static String PCARD_ZWUPTIME = "ZwUpTime";
	public final static String PCARD_ZWUPTYPE = "ZwUpType";
	public final static String PCARD_SWOFFTYPE = "SwOffType";
	public final static String PCARD_SWOFFTIME = "SwOffTime";
	public final static String PCARD_PLACEID="PLID";
	/**
	 * @category ��Ϊ json headֵ begin
	 */
	// ��¼
	public final static String V_ACT_LOGIN = "login";
	// �����ϱ�
	public final static String V_ACT_REPORT = "approve";
	// �����ϱ�
	public final static String V_PART_REPORT = "Partapprove";

	// ���˲������б�
	public final static String V_ACT_READY_EXAMINE_LIST = "ReadyExamineList";
	// ���˲����񵥸�����
	public final static String V_ACT_READY_EXAMINE = "GetCaseInfo";
	// ȷ�Ϻ˲�
	public final static String V_ACT_READY_EXAMINE_SUBMIT = "inspect";

	// ����ʵ�����б�
	public final static String V_ACT_READY_VERIFY_LIST = "WaitingforInspectVerification";
	// ����ʵ���񵥸�����
	public final static String V_ACT_READY_VERIFY = "WaitingforInspectCaseInfo"; //
	// ȷ�Ϻ�ʵ
	public final static String V_ACT_READY_VERIFY_SUBMIT = "ReadyVerifySubmit"; //

	// �����������б�
	public final static String V_ACT_READY_DISPOSE_LIST = "WaitingforHandle";
	// ���������񵥸�����
	public final static String V_ACT_READY_DISPOSE = "HandleCaseInfo"; //
	// ȷ�ϰ���
	public final static String V_ACT_READY_DISPOSE_SUBMIT = "Handle"; //

	// ��ʷ��¼�б� ��*HISTORY �飩
	public final static String V_ACT_QUESTION_HISTORY_LIST = "QuestionHistoryList"; // -------------------
	// ��ʷ��¼��������
	public final static String V_ACT_QUESTION_HISTORY = "QuestionHistory"; // -------------------

	// ���д����ϱ�
	public final static String V_ACT_QUESTION_DISPOSED = "QuestionDisposed"; // -------------------
	// �켣�ϱ�
	public final static String V_ACT_LOCATION_REPORT = "SubmitTrack";

	// �����Դ���
	public final static String WENTIZHICHULI = "CaseSelf";

	// ���������б�
	public final static String V_ACT_ADMINI_APPROVE_LIST = "AdminiApproveList";

	// ������������
	public final static String V_ACT_ADMINI_APPROVE_DETAIL = "GetAdminiApprove";

	// ��ȡ�¼�������Ϣ
	public final static String V_ACT_ADMINI_GET_ALLTYPE = "GetAllTypeNew";
	public final static String V_ACT_ADMINI_EVENT_TYPE = "eventtype";

	/**
	 * ��Ϊ json headֵ end
	 */

	/**
	 * *HISTORY BTGIN
	 */
	public final static String V_ACT_QUESTION_HISTORY_TYPE_REPORT = "sb";
	public final static String V_ACT_QUESTION_HISTORY_TYPE_EXMINE = "hc";
	public final static String V_ACT_QUESTION_HISTORY_TYPE_VERIFY = "hs";
	public final static String V_ACT_QUESTION_HISTORY_TYPE_DISPOSE = "bl";
	public final static int V_ACT_QUESTION_HISTORY_LIST_MAX = 10;
	/**
	 * *HISTORY END
	 */

	/**
	 * @category Login json �ֶ��� begin
	 */
	// request
	public final static String S_USER_INFO = "uInfo";
	public final static String S_AUTO_LOGIN = "autoLogin";
	// �û���
	public final static String R_USER_REQUEST_USERNAME_NAME = "LoginName";
	// ����
	public final static String R_USER_REQUEST_PASSCODE = "LoginPassWord";
	/*
	 * response
	 */
	// ��¼�ɹ�
	public final static String R_USER_RESPONSE_KEY = "isSuccess";
	// ������Ϣ
	public final static String R_USER_RESPONSE_MSG = "message";
	// Ȩ��
	public final static String R_USER_RESPONSE_LIMIT = "Limit";
	// ��������
	public final static String R_USER_RESPONSE_GRIDINFO = "GridInfo";
	/**
	 * Login json �ֶ��� end
	 */

	/**
	 * @category �����ϱ� json �ֶ��� begin
	 */
	// �绰
	public final static String R_REPORT_RESPONSE_CASES_NUM = "casesNum";
	// �绰
	public final static String R_REPORT_RESPONSE_TEL = "ComplainterTel";
	// ����
	public final static String R_REPORT_RESPONSE_NEME = "ComplainterName";
	// ��ס��ַ
	public final static String R_REPORT_RESPONSE_LIVE_ADRES = "ComplainterAddress";
	// ��¼�ʺ�
	public final static String R_REPORT_RESPONSE_USER_NAME = "ACCEPTUSERID";
	// ѡ������
	public final static String R_REPORT_RESPONSE_TYPE = "CASEITEM";
	// ��Ҫ����
	public final static String R_REPORT_RESPONSE_ALL_TYPE = "CASETITLE";
	// ��ϸ����
	public final static String R_REPORT_RESPONSE_DESCRIPT = "CASEDESCRIPTION";
	// ��ַ
	public final static String R_REPORT_RESPONSE_ADRES = "CASEADDRESS";
	// x����
	public final static String R_REPORT_RESPONSE_X = "X";
	// y����
	public final static String R_REPORT_RESPONSE_Y = "Y";
	// ������
	public final static String R_REPORT_RESPONSE_GRID_CODE = "GridCode";
	// ͼƬ����
	public final static String R_REPORT_RESPONSE_FLIST = "FList";
	// ͼƬ��
	public final static String R_REPORT_RESPONSE_FNAME = "FName";
	// ͼƬ����
	public final static String R_REPORT_RESPONSE_FDATA = "FData";
	// ͼƬ����
	public final static String R_REPORT_RESPONSE_FTYPE = "FType";
	/**
	 * �����ϱ� json �ֶ��� end
	 * 
	 */

	public final static String OBJECTID = "OBJECTID";
	public final static String OBJCODE = "OBJCODE";
	public final static String OBJNAME = "OBJNAME";
	public final static String DEPTCODE1 = "DEPTCODE1";
	public final static String DEPTNAME1 = "DEPTNAME1";
	public final static String DEPTCODE2 = "DEPTCODE2";
	public final static String DEPTNAME2 = "DEPTNAME2";
	public final static String DEPTCODE3 = "DEPTCODE3";
	public final static String DEPTNAME3 = "DEPTNAME3";
	public final static String EXTEND4 = "EXTEND4";

	/**
	 * @category ȷ�Ϻ˲���ϸ json �ֶ��� begin
	 */
	public final static String R_EXAMINE_REQUEST_CASE_ID = "CaseID";

	/**
	 * ȷ�Ϻ˲���ϸ json �ֶ��� end
	 */

	/**
	 * @category ȷ�Ϻ˲� json �ֶ��� begin
	 */
	// 1==ͨ��/ 0==��ͨ��
	public final static String R_EXAMINE_REQUEST_IS_OK = "IsOK";

	public final static String R_EXAMINE_REQUEST_INSPECT_ID = "InspectID";

	public final static String R_EXAMINE_REQUEST_VERIFYEED_BACK_CONTENT = "VerifyeedBackContent";

	public final static String R_EXAMINE_REQUEST_CASE_CODE = "CaseCode";

	public final static String R_EXAMINE_REQUEST_LOGIN_NAME = "LoginName";

	/**
	 * ȷ�Ϻ˲� json �ֶ��� end
	 */

	/**
	 * @category ���������񵥸����� json �ֶ��� begin
	 */
	public final static String R_DISPOSE_REQUEST_CASE_ID2 = "CaseID";

	/**
	 * ���������񵥸����� json �ֶ��� end
	 */

	/**
	 * @category ȷ�ϰ��� json �ֶ��� begin
	 */
	// 1==ͨ��/ 0==��ͨ��
	public final static String R_DISPOSE_REQUEST_IS_OK = "IsOK";

	public final static String R_DISPOSE_REQUEST_DEAL_RESULT = "DealResult";

	public final static String R_DISPOSE_REQUEST_TASK_ID = "TaskID";

	public final static String R_DISPOSE_REQUEST_HAND_ID = "HandID";

	public final static String R_DISPOSE_REQUEST_CASE_ID = "CaseID";

	public final static String R_DISPOSE_REQUEST_LOGIN_NAME = "LoginName";
	// ͼƬ����
	public final static String R_DISPOSE_REQUEST_FLIST = "FList";
	// ͼƬ��
	public final static String R_DISPOSE_REQUEST_FNAME = "FName";
	// ͼƬ����
	public final static String R_DISPOSE_REQUEST_FDATA = "FData";
	// ͼƬ����
	public final static String R_DISPOSE_REQUEST_FTYPE = "FType";
	/**
	 * ȷ�ϰ��� json �ֶ��� end
	 */

	/**
	 * @category ����ʵ���� json �ֶ��� begin
	 */
	public final static String R_READY_VERIFY_CASE_ID = "CaseID";

	/**
	 * ����ʵ���� json �ֶ��� end
	 */

	/**
	 * @category ����ʵ�ύ json �ֶ��� begin
	 */
	// 1==ͨ��/ 0==��ͨ��
	public final static String R_READY_VERIFY_SUBMIT_IS_OK = "IsOK";

	public final static String R_READY_VERIFY_SUBMIT_INSPECT_ID = "InspectID";

	public final static String R_READY_VERIFY_SUBMIT_VERIFYEED_BACK_CONTENT = "VerifyeedBackContent";

	public final static String R_READY_VERIFY_SUBMIT_LOGIN_NAME = "LoginName";

	public final static String R_READY_VERIFY_SUBMIT_CASE_CODE = "CaseCode";
	// ͼƬ����
	public final static String R_READY_VERIFY_SUBMIT_FLIST = "FList";
	// ͼƬ��
	public final static String R_READY_VERIFY_SUBMIT_FNAME = "FName";
	// ͼƬ����
	public final static String R_READY_VERIFY_SUBMIT_FDATA = "FData";
	// ͼƬ����
	public final static String R_READY_VERIFY_SUBMIT_FTYPE = "FType";

	/**
	 * ����ʵ�ύ json �ֶ��� end
	 */

	/**
	 * @category ��ʷ�б� json �ֶ��� begin
	 */
	public final static String R_READY_HISTORY_LIST_SEARCH_TYPE = "SearchType";

	public final static String R_READY_HISTORY_LIST_PAGE_INDEX = "PageIndex";

	public final static String R_READY_HISTORY_LIST_PAGE_SIZE = "PageSize";

	public final static String R_READY_HISTORY_LIST_RECORD_COUNT = "RecordCount";

	/**
	 * ��ʷ�б� json �ֶ��� end
	 */

	/**
	 * @category ��ʷ���� json �ֶ��� begin
	 */
	public final static String R_READY_HISTORY_CASE_ID = "CaseID";
	// ��������ID
	public final static String R_READY_APPROVE_ADTIVE_ID = "ADTIVEID";
	/**
	 * ��ʷ�б� json �ֶ��� end
	 */

	/**
	 * @category �켣�ϴ� json �ֶ��� begin
	 */
	public final static String R_LOCAL_REQUEST_KEY = "Key";

	public final static String R_LOCAL_REQUEST_TYPE = "Type";

	public final static String R_LOCAL_REQUEST_X = "X";

	public final static String R_LOCAL_REQUEST_Y = "Y";

	/**
	 * �켣�ϴ� json �ֶ��� end
	 */

	/**
	 * @category �����ϱ����ݿ��ݴ��ֶ� begin
	 */
	public final static String TABLE_NAME_QUESTION = "T_QUESTION";

	public final static String Q_QUESTION_ID = "Q_QUESTION_ID";

	public final static String Q_QUESTION_TYPE = "Q_QUESTION_TYPE";

	public final static String Q_QUESTION_TYPE1 = "Q_QUESTION_TYPE_1";

	public final static String Q_QUESTION_TYPE2 = "Q_QUESTION_TYPE_2";

	public final static String Q_QUESTION_LOCATION = "Q_QUESTION_LOCATION";

	public final static String Q_QUESTION_DESCRIPT = "Q_QUESTION_DESCRIPT";

	public final static String Q_QUESTION_BEFOR_IMG1 = "Q_QUESTION_BEFOR_IMG_1";

	public final static String Q_QUESTION_BEFOR_IMG2 = "Q_QUESTION_BEFOR_IMG_2";

	public final static String Q_QUESTION_BEFOR_IMG3 = "Q_QUESTION_BEFOR_IMG_3";

	public final static String Q_QUESTION_AFTER_IMG1 = "Q_QUESTION_AFTER_IMG_1";

	public final static String Q_QUESTION_AFTER_IMG2 = "Q_QUESTION_AFTER_IMG_2";

	public final static String Q_QUESTION_AFTER_IMG3 = "Q_QUESTION_AFTER_IMG_3";

	public final static String Q_QUESTION_REC1 = "Q_QUESTION_REC_1";

	public final static String Q_QUESTION_REC2 = "Q_QUESTION_REC_2";

	public final static String Q_QUESTION_REC3 = "Q_QUESTION_REC_3";

	public final static String Q_QUESTION_CASESNUM = "Q_QUESTION_CASESNUM";
	/**
	 * �����ϱ����ݿ��ݴ��ֶ� end
	 */
	public final static String TypeVison = "TypeVison";

	// ��ϵ��
	public final static String GetLinkManInfo = "GetLinkManInfo";
}
