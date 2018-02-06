package chestnut.com.babycirle.ui.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import chestnut.com.babycirle.R;
import chestnut.com.babycirle.constant.UtilTools;

/**
 * @author songzhengpeng
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.message)
    EditText message;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    ConstraintLayout container;
    @BindView(R.id.animation_view)
    LottieAnimationView animationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    message.setText(R.string.title_home);
                    UtilTools.uploadToUmengNew(MainActivity.this, "u_name", "完美世界");
                    return true;
                case R.id.navigation_dashboard:
                    message.setText(R.string.title_dashboard);
                    UtilTools.uploadToUmeng(MainActivity.this, "u_message", "锦上添花");
                    return true;
                case R.id.navigation_notifications:
                    message.setText(R.string.title_notifications);
                    UtilTools.uploadToUmeng(MainActivity.this, "u_head", "雪中送炭");
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initAnimationFolderPeter(animationView);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releaseAnimation(animationView, animationView);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
