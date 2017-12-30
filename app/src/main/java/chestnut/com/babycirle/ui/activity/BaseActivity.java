package chestnut.com.babycirle.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.umeng.message.PushAgent;

import butterknife.ButterKnife;


/**
 * Created by peter on 2017/11/23.
 * good choice
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        PushAgent.getInstance(getApplicationContext()).onAppStart();
    }

    /**
     * @return 获取布局文件的resID
     */
    protected abstract int getLayoutId();

    /**
     * 绑定控件
     */
    protected void bindView() {
    }

    /**
     * @param context
     * @param str     吐司父方法
     */
    protected void toast(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param view
     * @param str  snackbar的父方法
     */
    protected void showSimpleSnackbar(View view, String str) {
        Snackbar.make(view, str, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * @param view
     * @param str      提示主要内容
     * @param strRight 提示右侧的内容
     */
    protected void showCustomSnackbar(View view, String str, String strRight) {
        Snackbar.make(view, str, Snackbar.LENGTH_SHORT)
                .setAction(strRight, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //右侧文字的点击事件
                        toast(BaseActivity.this, "你戳我干什么！！！");
//                        Intent intent = new Intent(BaseActivity.this,MyWebViewActivity.class);
//                        startActivity(intent);
                    }
                })
                .show();
    }
}
