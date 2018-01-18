package chestnut.com.babycirle.app;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import chestnut.com.babycirle.constant.PreferenceManageTools;

/**
 * BabyCircle
 * Created by peter
 * on 2017.12
 *
 * @author songzhengpeng
 */

public class BabyCircleApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceManageTools.init(this);
        initUmengPush();
        initUmengAnalytics();
    }

    private void initUmengPush() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //上线改为false
        mPushAgent.setDebugMode(true);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("song", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("song", "失败了" + s + "\n" + s1);

            }
        });
    }

    private void initUmengAnalytics() {
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "05f4b4e4c204272ea059e96a32f03cd5");
        UMConfigure.setLogEnabled(true);
    }
}
