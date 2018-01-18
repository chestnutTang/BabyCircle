package chestnut.com.babycirle.constant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * BabyCircle
 * Created by peter
 * on 2018.01
 * SharedPreferences 工具类
 *
 * @author songzhengpeng
 */

public class PreferenceManageTools {

    private static PreferenceManageTools instance = null;

    private static final String KEY_PREFERENCE_NAME = "PREFERENCE";
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;

    public static synchronized PreferenceManageTools getInstance() {
        if (instance == null) {
            synchronized (PreferenceManageTools.class) {
                if (instance == null) {
                    instance = new PreferenceManageTools();
                }
            }
        }
        return instance;
    }

    public static synchronized void init(Context context) {
        mSharedPreferences = context.getSharedPreferences(KEY_PREFERENCE_NAME, Context
                .MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public void savaName(String name) {
        editor.putString("name", name);
        editor.apply();
    }

    public String getName() {
        return mSharedPreferences.getString("name", "");
    }
}
