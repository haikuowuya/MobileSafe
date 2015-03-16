package com.lilosoft.xtcm.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.lilosoft.xtcm.constant.Config;
import com.lilosoft.xtcm.constant.TableStructure;
import com.lilosoft.xtcm.instantiation.UserInfo;
import com.lilosoft.xtcm.utils.Base64Util;
import com.lilosoft.xtcm.utils.LogFactory;

/**
 * @category ���ݴ洢
 * @author William Liu
 *
 */
public class SharedPreferencesFactory {

    /**
     * @category �����Ķ���
     */
    private static Context context;
    /**
     * @category TAG
     */
    private final String TAG = "SharedPreferencesFactory";
    /**
     * @category content
     */
    private String uInfo;

    /**
     * @category content�޸�token
     */
    private boolean CHANGE_USER = false;

    /**
     * @category ��¼�����û������±�
     */
    private int bit = 0;

    /**
     * IP ����
     *
     * @param mContext
     * @return
     */
    private static SharedPreferences getSPIpConfig(Context mContext) {
        context = mContext;
        return mContext.getSharedPreferences(Config.SHARED_PREFERENCES_IC,
                android.content.Context.MODE_PRIVATE);

    }

    public static String getConfig(Context mContext) {
        SharedPreferences localEditor = getSPIpConfig(mContext);

        String uInfoCode = localEditor.getString("url_", null);

        if (null != uInfoCode) {
            String strs[] = uInfoCode.split(",");
            Config.refreshURL_("http://" + strs[0] + ":" + strs[1] + "/");
            LogFactory.e("", uInfoCode);
        }

        return uInfoCode;

    }

    public static String getMapConfig(Context mContext) {
        SharedPreferences localEditor = getSPIpConfig(mContext);

        String uInfoCode = localEditor.getString("Mapurl_", null);

        if (null != uInfoCode) {
            String strs[] = uInfoCode.split(",");
            Config.refreshMapURL_("http://" + strs[0] + ":" + strs[1] + "/");
            LogFactory.e("", uInfoCode);
        }

        return uInfoCode;

    }

    /**
     * @category ��ȡSharedPreferencesʵ��
     * @param mContext
     * @return
     */
    private SharedPreferences getSharedPreferences(Context mContext) {
        context = mContext;
        return mContext.getSharedPreferences(Config.SHARED_PREFERENCES_NAME,
                android.content.Context.MODE_PRIVATE);

    }

    /**
     * @category �����û�����
     * @param mContext
     * @param user
     * @param psw
     * @return
     */
    public void savaUserInfo(Context mContext, String userName, String userPsw,
                             boolean autoLogin) {

        readUserInfo(mContext);

        if (null != uInfo) {

            if (!checkUserExistsStatus(userName, userPsw, autoLogin)) {

                int uInfoLength = uInfo.split("\\|").length;

                if (uInfoLength > 0) {

                    LogFactory.e(TAG, "don't has user");

                    Editor localEditor = getSharedPreferences(mContext).edit();

                    String userInfo = userName + "," + userPsw + "|" + uInfo;

                    localEditor.putString(TableStructure.S_USER_INFO,
                            new Base64Util().enBese64(userInfo.getBytes()));

                    localEditor.putBoolean(TableStructure.S_AUTO_LOGIN,
                            autoLogin);

                    localEditor.commit();

                } else {

                    LogFactory.e(TAG, "user has one or none");

                    Editor localEditor = getSharedPreferences(mContext).edit();

                    String userInfo = userName + "," + userPsw;

                    localEditor.putString(TableStructure.S_USER_INFO,
                            new Base64Util().enBese64(userInfo.getBytes()));

                    localEditor.putBoolean(TableStructure.S_AUTO_LOGIN,
                            autoLogin);

                    localEditor.commit();

                }

            } else {

                LogFactory.e(TAG, "user has");

                if (0 != bit) {
                    LogFactory.e(TAG, "has this User but don not at frist");
                    CHANGE_USER = true;
                }

                if (CHANGE_USER)
                    changeUser(userName, userPsw, autoLogin);
            }

        } else {

            LogFactory.e(TAG, "frist create user");

            Editor localEditor = getSharedPreferences(mContext).edit();

            String userInfo = userName + "," + userPsw;

            localEditor.putString(TableStructure.S_USER_INFO,
                    new Base64Util().enBese64(userInfo.getBytes()));

            localEditor.putBoolean(TableStructure.S_AUTO_LOGIN, autoLogin);

            localEditor.commit();

        }

    }

    /**
     * @category ��ȡ�û�����
     * @param mContext
     */
    private void readUserInfo(Context mContext) {

        SharedPreferences localEditor = getSharedPreferences(mContext);

        String uInfoCode = localEditor.getString(TableStructure.S_USER_INFO,
                null);

        if (null != uInfoCode) {
            uInfoCode = new Base64Util().deBese64(uInfoCode);
        }

        uInfo = uInfoCode;

    }

    /**
     * @category �˻��Ƿ��Զ���¼
     * @param mContext
     * @return
     */
    public boolean isAutoLogin(Context mContext) {

        SharedPreferences localEditor = getSharedPreferences(mContext);

        return localEditor.getBoolean(TableStructure.S_AUTO_LOGIN, false);

    }

    /**
     * @category ��ȡ��Կ
     * @return
     */
    public String readKey(Context mContext) {

        SharedPreferences localEditor = getSharedPreferences(mContext);

        return localEditor.getString(Config.SHARED_PREFERENCES_KEY, null);
    }

    /**
     * @category д��Կ
     * @param mContext
     * @param key
     */
    public void writeKey(Context mContext, String key) {

        Editor editor = getSharedPreferences(mContext).edit();
        editor.putString(Config.SHARED_PREFERENCES_KEY, key);
        editor.commit();

    }

    /**
     * @category ����û����Ƿ����
     *
     * @return
     */
    private boolean checkUserExistsStatus(String userName, String userPsw,
                                          boolean autoLogin) {

        if (null != uInfo) {
            String[] allUser = uInfo.split("\\|");
            if (null != allUser) {
                int length = allUser.length;
                for (int i = 0; i < length; i++) {
                    if (allUser[i].split(",")[0].equals(userName)) {
                        if (!allUser[i].split(",")[1].equals(userPsw)) {
                            LogFactory.e(TAG, "passcode is different");
                            CHANGE_USER = true;
                        }
                        bit = i;
                        return true;
                    }
                }
            }
        }

        return false;

    }

    /**
     * @category �ı��û�
     * @param userName
     * @param userPsw
     * @return
     */
    private void changeUser(String userName, String userPsw, boolean autoLogin) {

        Editor localEditor = getSharedPreferences(context).edit();

        String userInfo = "";
        int uInfoLength = uInfo.split("\\|").length;
        if (uInfoLength > 1) {
            if (-1 != uInfo.indexOf("|" + userName)) {

                if (uInfo.lastIndexOf("|") == uInfo.lastIndexOf("|" + userName)) {

                    LogFactory.e(TAG, "change last user");

                    userInfo = userName + "," + userPsw + "|"
                            + uInfo.substring(0, uInfo.lastIndexOf("|"));

                } else {

                    LogFactory.e(TAG, "change middle user");

                    String s2 = uInfo
                            .substring(uInfo.indexOf("|" + userName) + 1);

                    userInfo = userName + "," + userPsw + "|"
                            + uInfo.substring(0, uInfo.indexOf(userName))
                            + s2.substring(s2.indexOf("|") + 1);

                }

            } else if (-1 != uInfo.indexOf(userName)) {

                LogFactory.e(TAG, "change frist user");

                userInfo = userName + "," + userPsw + "|"
                        + uInfo.substring(uInfo.indexOf("|") + 1);

            }
        } else {

            userInfo = userName + "," + userPsw;

            LogFactory.e(TAG, "change has one or none");

        }

        localEditor.putString(TableStructure.S_USER_INFO,
                new Base64Util().enBese64(userInfo.getBytes()));

        localEditor.putBoolean(TableStructure.S_AUTO_LOGIN, autoLogin);

        localEditor.commit();

        CHANGE_USER = false;

    }

    /**
     * @category ��ȡ�����û��� AutoCompleteTextView ʹ��
     *
     * @param mContext
     * @return
     */
    public String[] getAllUserName(Context mContext) {

        readUserInfo(mContext);

        if (null != uInfo && "" != uInfo) {
            String[] allUser = uInfo.split("\\|");
            String[] allUserName;
            if (null != allUser) {
                int length = allUser.length;
                allUserName = new String[length];
                for (int i = 0; i < length; i++) {
                    allUserName[i] = allUser[i].split(",")[0];
                }
                return allUserName;
            }
        }

        return null;

    }

    /**
     * @category ����׸��û�
     * @param mContext
     * @return
     */
    public UserInfo getTopUser(Context mContext) {

        readUserInfo(mContext);

        if (null != uInfo && "" != uInfo) {
            String[] allUser = uInfo.split("\\|");
            if (null != allUser) {
                String[] oneUser = allUser[0].split(",");
                UserInfo uUserInfo = new UserInfo();
                uUserInfo.setUsername(oneUser[0]);
                uUserInfo.setPasscode(oneUser[1]);
                return uUserInfo;
            }
        }

        return null;

    }

    public void changeIpConfig(Context mContext, String ip, String point) {

        Editor localEditor = getSPIpConfig(mContext).edit();

        String content = ip + "," + point;

        localEditor.putString("url_", content);

        localEditor.commit();

        Config.refreshURL_("http://" + ip + ":" + point + "/");
    }

    public void changeMapIpConfig(Context mContext, String ip, String point) {

        Editor localEditor = getSPIpConfig(mContext).edit();

        String content = ip + "," + point;

        localEditor.putString("Mapurl_", content);

        localEditor.commit();

        Config.refreshMapURL_("http://" + ip + ":" + point + "/");
    }

}
