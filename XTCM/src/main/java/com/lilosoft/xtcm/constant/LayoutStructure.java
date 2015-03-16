package com.lilosoft.xtcm.constant;

import com.lilosoft.xtcm.R;

public class LayoutStructure {

	/**
	 * @category �ֶα��
	 */
	public final static String[] from = new String[] { "AAAAAA", "BBBBBB",
			"CCCCCC", "DDDDDD", "EEEEEE", "FFFFFF", "GGGGGG", "HHHHHH",
			"IIIIII", "JJJJJJ", "KKKKKK", "LLLLLL", "MMMMMM", "NNNNNN",
			"OOOOOO", "PPPPPP", "QQQQQQ", "RRRRRR", "SSSSSS", "TTTTTT",
			"UUUUUU", "VVVVVV", "WWWWWW", "XXXXXX", "YYYYYY", "ZZZZZZ" };

	/**
	 * @category �˲�ؼ�Ԫ��
	 */
	public final static int[] toExamineItem = new int[] {
			R.id.q_small_inspectid, R.id.q_small_caseid, R.id.q_small_casecode,
			R.id.q_small_casestatus, R.id.q_small_caseparentitem1,
			R.id.q_small_caseparentitem2, R.id.q_small_caseitem,
			R.id.q_small_putonrecordextendedtime,
			R.id.q_small_putonrecorduserid, R.id.q_small_beginverifytime,
			R.id.q_small_casetitle, R.id.q_small_putonrecordwarningtime };

	/**
	 * @category ����ؼ�Ԫ��
	 */
	public final static int[] toReadyDispose = new int[] { R.id.q_small_caseid,
			R.id.q_small_taskid, R.id.q_small_signid, R.id.q_small_handleid,
			R.id.q_small_casecode, R.id.q_small_casestatus,
			R.id.q_small_caseparentitem1, R.id.q_small_caseparentitem2,
			R.id.q_small_caseitem, R.id.q_small_dispatchtime,
			R.id.q_small_dealextendedtime, R.id.q_small_dispatchtype,
			R.id.q_small_dispatchpersonid, R.id.q_small_casetitle,
			R.id.q_small_dealwarmingtime };

	/**
	 * @category ��ʵ�ؼ�Ԫ��
	 */
	public final static int[] toVerifyItem = new int[] { R.id.q_small_caseid,
			R.id.q_small_taskid, R.id.q_small_signid, R.id.q_small_handleid,
			R.id.q_small_verificationid, R.id.q_small_inspectid,
			R.id.q_small_casecode, R.id.q_small_casestatus,
			R.id.q_small_caseparentitem1, R.id.q_small_caseparentitem2,
			R.id.q_small_caseitem, R.id.q_small_signdeptcode,
			R.id.q_small_verifyperson, R.id.q_small_beginverifytime,
			R.id.q_small_verifyperson1, R.id.q_small_dealuserid,
			R.id.q_small_casetitle, R.id.q_small_feedbackdealtime };

	/**
	 * @category ��ʷ�ϱ��ؼ�Ԫ��
	 */
	public final static int[] toHistoryReportItem = new int[] {
			R.id.q_small_id, R.id.q_small_casecode, R.id.q_small_casestatus,
			R.id.q_small_caseparentitem1, R.id.q_small_caseparentitem2,
			R.id.q_small_caseitem, R.id.q_small_complainanterid,
			// R.id.q_small_casetitle,
			R.id.q_small_casedescription, R.id.q_small_createtime };

	/**
	 * @category ��ʷ��ʵ�ؼ�Ԫ��
	 */
	public final static int[] toHistoryExaminetItem = new int[] {
			R.id.q_small_caseid, R.id.q_small_inspectid, R.id.q_small_casecode,
			R.id.q_small_casestatus, R.id.q_small_caseparentitem1,
			R.id.q_small_caseparentitem2, R.id.q_small_caseitem,
			R.id.q_small_verifyperson, R.id.q_small_ispassverify,
			R.id.q_small_finishverifytime, R.id.q_small_casedescription,
			R.id.q_small_beginverifytime };

	/**
	 * @category ��ʷ�˲�ؼ�Ԫ��
	 */
	public final static int[] toHistoryVerifyItem = new int[] {
			R.id.q_small_caseid,
			// R.id.q_small_casetitle,
			R.id.q_small_casedescription, R.id.q_small_finishverifytime, };

	/**
	 * @category ��ʷ����ؼ�Ԫ��
	 */
	public final static int[] toHistoryDisposeItem = new int[] {
			R.id.q_small_caseid, R.id.q_small_taskid, R.id.q_small_signid,
			R.id.q_small_handleid, R.id.q_small_casecode,
			R.id.q_small_casestatus, R.id.q_small_caseparentitem1,
			R.id.q_small_caseparentitem2, R.id.q_small_caseitem,
			R.id.q_small_dispatchtype, R.id.q_small_dispatchpersonid,
			R.id.q_small_feedbackdealtime, R.id.q_small_rn,
			R.id.q_small_casetitle, R.id.q_small_dispatchtime };

	/**
	 * @category �������ؼ�Ԫ��
	 */
	public final static int[] toAdminApproveItem = new int[] {
			R.id.q_small_title, R.id.q_small_other };

}
