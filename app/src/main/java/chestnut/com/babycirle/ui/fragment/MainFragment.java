package chestnut.com.babycirle.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.plus.PlusOneButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import chestnut.com.babycirle.R;


public class MainFragment extends BaseFragment {
    @BindView(R.id.plus_one_button)
    PlusOneButton plusOneButton;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.animation_view)
    LottieAnimationView animationView;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        //初始化加载动画
        if (animationView == null){
            animationView = container.findViewById(R.id.animation_view);
        }
        initAnimationFolderPeter(animationView);
        unbinder = ButterKnife.bind(this, super.onCreateView(inflater, container, savedInstanceState));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plus_one;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setTitle(String title) {
        txtName.setText(title);
    }
}
