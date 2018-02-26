package chestnut.com.babycirle.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import chestnut.com.babycirle.R;
import chestnut.com.babycirle.constant.UtilTools;
import chestnut.com.babycirle.ui.fragment.MainFragment;
import chestnut.com.babycirle.ui.fragment.MainFragment2;
import chestnut.com.babycirle.ui.fragment.MainFragment3;

/**
 * @author songzhengpeng
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.message)
    TextInputEditText message;
    @BindView(R.id.input_layout)
    TextInputLayout inputLayout;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    ConstraintLayout container;
    @BindView(R.id.animation_view)
    LottieAnimationView animationView;

    MainFragment mainFragment;
    MainFragment2 mainFragment2;
    MainFragment3 mainFragment3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    message.setText(R.string.title_home);
                    UtilTools.uploadToUmengNew(MainActivity.this, "u_name", "完美世界");
                    switchFragments(mainFragment);
                    getScreenSize();
                    return true;
                case R.id.navigation_dashboard:
                    message.setText(R.string.title_dashboard);
                    UtilTools.uploadToUmeng(MainActivity.this, "u_message", "锦上添花");
                    switchFragments(mainFragment2);
                    return true;
                case R.id.navigation_notifications:
                    message.setText(R.string.title_notifications);
                    UtilTools.uploadToUmeng(MainActivity.this, "u_head", "雪中送炭");
                    switchFragments(mainFragment3);
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    private void getScreenSize() {
        DisplayMetrics DisplayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(DisplayMetrics);
        Log.e("song", "宽度：" + DisplayMetrics.widthPixels);
        Log.e("song", "高度：" + DisplayMetrics.heightPixels);
        toast(getApplicationContext(), "宽度：" + DisplayMetrics.widthPixels);
        toast(getApplicationContext(), "高度：" + DisplayMetrics.heightPixels);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化加载动画
        initAnimationFolderPeter(animationView);
        //绑定fragment
        bindFragments();

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseAnimation(animationView, animationView);
            }
        });
    }

    /**
     * 绑定fragment
     */
    private void bindFragments() {
        mainFragment = new MainFragment();
        mainFragment2 = new MainFragment2();
        mainFragment3 = new MainFragment3();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * @param fragment 切换fragment
     */
    private void switchFragments(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}
