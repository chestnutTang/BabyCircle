package chestnut.com.babycirle.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import chestnut.com.babycirle.R;

/**
 * @author songzhengpeng
 */
public class WelcomeActivity extends BaseActivity {

    private static final int KEY_SUCCESS = 1;

    static class MyHandler extends Handler {
        WeakReference<WelcomeActivity> welcomeActivityWeakReference;
        Activity activity = null;

        MyHandler(WelcomeActivity activity) {
            welcomeActivityWeakReference = new WeakReference<>(activity);
            this.activity = activity;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            WelcomeActivity welcomeActivity = welcomeActivityWeakReference.get();
            if (welcomeActivity != null) {
                switch (msg.what) {
                    case KEY_SUCCESS:
                        Intent intent = new Intent(welcomeActivity, MainActivity.class);
                        welcomeActivity.startActivity(intent);
                        welcomeActivity.finish();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private MyHandler handler = new MyHandler(WelcomeActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler.sendEmptyMessageDelayed(KEY_SUCCESS, 3000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

}
