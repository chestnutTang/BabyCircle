package chestnut.com.babycirle.constant;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;

/**
 * BabyCircle
 * Created by peter
 * on 2018.01
 */

public class UtilTools {

    /**
     * @param context
     * @param eventName
     * @param eventValue 友盟统计事件
     */
    public static void uploadToUmeng(Context context, String eventName, String eventValue) {
        HashMap<String, String> uKey = new HashMap<>();
        uKey.put("uKey", eventValue);
        MobclickAgent.onEvent(context, eventName, uKey);

//        MobclickAgent.onEventValue(context, "u_name", uKey, 0);
    }

    public static void uploadToUmengNew(Context context, String eventName, String eventValue) {
        HashMap<String, String> uKey = new HashMap<>();
        uKey.put("uKey", eventValue);
//        MobclickAgent.onEvent(context, eventName, uKey);

        MobclickAgent.onEventValue(context, eventName, uKey, 0);
    }
}
