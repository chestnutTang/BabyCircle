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
import android.view.ViewGroup;

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

    /**
     * 树形结构练习
     *
     * @param vp
     * @param id
     * @return 返回一个在vg下面的一个View，id为方法的第二个参数
     */
    public static View find(ViewGroup vp, int id) {
        if (vp == null) {
            return null;
        } else {
            int size = vp.getChildCount();
            //循环遍历所有孩子
            for (int i = 0; i < size; i++) {
                View view = vp.getChildAt(i);
                //如果当前孩子的id相同，那么返回
                if (view.getId() == i) {
                    return view;
                }
                //如果当前孩子id不同，但是是一个ViewGroup，那么我们递归往下找
                else if (view instanceof ViewGroup) {
                    //递归
                    View view1 = find((ViewGroup) view, id);
                    //如果找到了，就返回temp，如果没有找到，继续当前的for循环
                    if (view1 != null) {
                        return view1;
                    }
                }
            }
        }
        //到最后还没用找到，代表该ViewGroup vg 并不包含一个有该id的孩子，返回空
        return null;
    }

}
