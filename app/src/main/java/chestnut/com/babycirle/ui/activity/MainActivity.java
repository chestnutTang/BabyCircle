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
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;

import butterknife.BindView;
import chestnut.com.babycirle.R;

/**
 * @author songzhengpeng
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.message)
    TextView message;
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
                    return true;
                case R.id.navigation_dashboard:
                    message.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    message.setText(R.string.title_notifications);
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
        animationView.setImageAssetsFolder("peter/");
        animationView.setAnimation("data.json");
        animationView.loop(true);
        // 任何符合颜色过滤界面的类
        final PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED,
                PorterDuff.Mode.LIGHTEN);
//
//// 在整个视图中添加一个颜色过滤器
//        animationView.addColorFilter(colorFilter);
        animationView.setColorFilter(colorFilter);
        animationView.playAnimation();
//        Cancellable compositionCancellable = LottieComposition.Factory.fromJson(getResources(),
// jsonObject, (composition) -> {
//            animationView.setComposition(composition);
//            animationView.playAnimation();
//        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationView.cancelAnimation();
                animationView.clearAnimation();
//                animationView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
