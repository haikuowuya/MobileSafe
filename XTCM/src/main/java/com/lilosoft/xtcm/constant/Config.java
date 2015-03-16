package com.lilosoft.xtcm.constant;

import java.io.File;

import android.content.SharedPreferences;
import android.os.Environment;

/**
 * @category ����
 * @author William Liu
 * 
 */
public class Config {

	public final static String TELNUM = "07283605522";

	/**
	 * @category logLevel true=��Ӫģʽ false=����ģʽ
	 */
	public final static boolean LOGLEVEL = false;

	/**
	 * @category ����ģʽ true=���� false=����
	 */
	public final static boolean NETWORK = false;

	/**
	 * @category �����������ݱ����ʽ
	 */
	public final static String CHARSET = "UTF-8";
	/**
	 * @category ��������ʱʱ��
	 */
	public final static int CONNECTION_TIMEOUT = 300000;
	public final static int SO_TIMEOUT = 100000;
	/**
	 * @category ���ݿ���
	 */
	public final static String DATABASE_NAME = "xtcm.db";
	public final static int DATABASE_VERSION = 4;
	/**
	 * @category ��ʱ���ݱ����ļ���
	 */
	public final static String SHARED_PREFERENCES_NAME = "XTCM_sp";
	public final static String SHARED_PREFERENCES_ISUPDATE = "isUpdateEvent";//�Ƿ�����¼�������Ϣ
	public final static String SHARED_PREFERENCES_IC = "XTCM_IC";
	public final static String SHARED_PREFERENCES_KEY = "key0x9480";
	/**
	 * @category �ȴ���״̬
	 */
	public final static int DISMISS_PROGRESS_DIALOG = 0xDDFFFFFF;
	public final static int SHOW_PROGRESS_DIALOG = 0xDD000001;
	/**
	 * @category ������
	 */
	public final static int MSG_LOST_404 = 0x108FFFFF;
	/**
	 * @category ����ʧ��
	 */
	public final static int MSG_LOST_CONN = 0x1008FFFF;
	/**
	 * @category �����쳣
	 */
	public final static int MSG_LOST_JSON = 0x10008FFF;
	/**
	 * @category TAB�ֶ�
	 */
	public final static String A_TAB = "A_TAB";
	public final static String B_TAB = "B_TAB";
	public final static String C_TAB = "C_TAB";
	public final static String D_TAB = "D_TAB";
	public final static String E_TAB = "E_TAB";
	// ���ݵı���
	public static final String HOUSE_CODE = "HOUSE_CODE";
	public static final String FWDBM = "FWDBM";
	// ��ַ����
	public static final String DZMC = "DESC1";
	public static final String TypeVison = "TypeVison";
	/**
	 * @category ��ַ�Զ��ϱ����
	 */
	private final static int SECOND = 1000;

	/**
	 * @category ��ʽ����
	 */
	// private static String URL_ = "http://218.200.131.71/";
	//private static String URL_ = "http://192.168.4.102:8003/";
//	private static String URL_="http://192.168.4.251:8003/";
	private final static int MINUTE = SECOND * 60;
	public final static long AUTO_LOCATION_REPORT_TIME = MINUTE * 2;
	private final static String FILES_NAME = "Xiantao_city";
	public final static String FILES_NAME_URL = Environment
			.getExternalStorageDirectory()
			+ File.separator
			+ FILES_NAME
			+ File.separator;
	public static double pCardDistance=200;
//	public final static String VERSION_URL = "http://192.168.1.253:8003/DCG/MobilesInterfaces/apk/updateConfig.xml";
	/**
	 * @category �������� URL
	 */
//	 private static String URL_ = "http://221.233.244.57:8003/";
//	 private static String MAPURL_ = "http://192.168.4.252:6080/";

//	private static String URL_ = "http://192.168.120.117:8003/";//�ӿڷ�����
//	private static String MAPURL_ = "http://111.47.112.90:6080/";//��ͼ������

	private static String URL_ = "http://111.47.112.90:8003/";//�ӿڷ�����
	/**
	 * @category ����
	 */
//	public final static String VERSION_URL = URL_+"DCG/MobilesInterfaces/apk/updateConfig.xml";
	public final static String VERSION_URL = URL_+"DCG/MobilesInterfaces/apk/LeaderupdateConfig.xml";//�쵼��ͼ������ͼ��
	/**
	 * @category �ϴ�
	 */
	public static String URL_REPORT = URL_
			+ "DCG/MobilesInterfaces/Reported.aspx";
	/**
	 * @category �·�
	 */
	public static String URL_READY_ISSUED = URL_
			+ "DCG/MobilesInterfaces/Issued.aspx";
	/**
	 * @category �ļ��ϴ�
	 */
	public static String URL_READY_FILEUPLOAD = URL_
			+ "DCG/MobilesInterfaces/FileUpLoad.asmx";
	//private static String URL_ = "http://192.168.0.135:8003/";//�ӿڷ�����
//	private static String URL_ = "http://192.168.4.119:8003/";
	private static String MAPURL_ = "http://111.47.112.90:6080/";//��ͼ������

	//private static String MAPURL_ = "http://192.168.4.251:6080/";
//	private static String MAPURL_ = "http://192.168.4.250:6080/";
	/**
	 * ��
	 */
	public static final String PCARD_URL = MAPURL_
			+ "/arcgis/rest/services/shayang/region/MapServer/2";
	// public final static String MAP =
	// "http://221.233.244.57:6080/arcgis/rest/services/xiantao2d/MapServer";
	// ɳ��
	// public final static String MAP =
	// "http://192.168.4.250:6080/arcgis/rest/services/shayang2d/MapServer";
	/**
	 * @category ��ͼ
	 */
	// ����
	public static String MAP = MAPURL_
			+ "arcgis/rest/services/xiantao2d/MapServer";
	/**
	 * @category ����
	 */
	// ����
	/*public static String ARCGIS = MAPURL_
			+ "arcgis/rest/services/wg_xt_cg/MapServer/0";*/

//	public static String ARCGIS = MAPURL_+"arcgis/rest/services/wg21_xt_cg/MapServer/0";
//	public static String ARCGIS = MAPURL_+"arcgis/rest/services/xiantao/cm_grid_0811/MapServer/0";
	public static String ARCGIS = MAPURL_+"arcgis/rest/services/xiantao/cm_grid/MapServer/0";
//	public static String WORKURL = MAPURL_ + "arcgis/rest/services/xiantao/cm_work/MapServer/0";
	//http://111.47.112.90:6080/arcgis/rest/services/xiantao/cm_work/MapServer/0

	// public final static String ARCGIS =
	// "http://221.233.244.57:6080/arcgis/rest/services/wg21_xt_cg/MapServer/0";
	// public final static String ARCGIS =
	// "http://192.168.4.250:6080/arcgis/rest/services/wg_sy_cg/MapServer/0";
	//public static String ARCGIS = MAPURL_+"arcgis/rest/services/xiantao/cm_work/MapServer/0";
	public static String WORKURL = MAPURL_ + "arcgis/rest/services/xiantao/cm_workspace/MapServer/0";
	// ��ַ�㡢���㡢����id
	public static final String ADDRESS_LAYER_ID = MAPURL_+"/arcgis/rest/services/shayang/house/MapServer/0";
	public static final String HOUSE_LAYER_ID = MAPURL_+"/arcgis/rest/services/shayang/house/MapServer/1";
//	public static final String WG_LAYER_ID = MAPURL_+"/arcgis/rest/services/shayang/region/MapServer/3";
	public static final String WG_LAYER_ID = MAPURL_+"/arcgis/rest/services/xiantao/cm_grid/MapServer/0";
	public static final String CHECK_PLACE=MAPURL_+"/arcgis/rest/services/xiantao/cm_check/MapServer/0";
	public static final String TILED_MAP_SERVICE = MAPURL_+"/arcgis/rest/services/shayang/map2d/MapServer";
//	public static final String MAP_SERVICE = MAPURL_+"/arcgis/rest/services/shayang/region/MapServer";
	public static final String MAP_SERVICE = MAPURL_+"/arcgis/rest/services/xiantao/map2d/MapServer";

	/**
	 * @category ��õ�ַ
	 * @return String
	 */
	public static String getURL_() {
		return URL_;
	}
	
	/**
	 * @category ��õ�ַ
	 * @return String
	 */
	public static String getMapURL_() {
		return MAPURL_;
	}
	
	/**
	 * @category �޸�����
	 */
	public static void refreshURL_(String url) {
		URL_ = url;
		URL_REPORT = URL_ + "DCG/MobilesInterfaces/Reported.aspx";
		URL_READY_ISSUED = URL_ + "DCG/MobilesInterfaces/Issued.aspx";
		URL_READY_FILEUPLOAD = URL_ + "/DCG/MobilesInterfaces/FileUpLoad.asmx";
	}
	
	/**
	 * @category �޸�����
	 */
	public static void refreshMapURL_(String url) {
		MAPURL_ = url;
		MAP = MAPURL_ + "arcgis/rest/services/xiantao2d/MapServer";
		ARCGIS = MAPURL_ + "arcgis/rest/services/cm_grid_0811/MapServer/0";
	}
}
