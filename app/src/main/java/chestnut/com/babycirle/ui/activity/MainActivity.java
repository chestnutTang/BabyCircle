package chestnut.com.babycirle.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

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
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
