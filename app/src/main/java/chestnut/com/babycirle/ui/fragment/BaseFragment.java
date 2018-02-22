package chestnut.com.babycirle.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.ButterKnife;

/**
 * BabyCircle
 * Created by peter
 * on 2017.12
 *
 * @author songzhengpeng
 */

public abstract class BaseFragment extends Fragment {

    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getLayoutId();

    /**
     * @param animationView 初始化加载动画
     */
    protected void initAnimationFolderPeter(LottieAnimationView animationView) {
        animationView.setImageAssetsFolder("peter/");
        animationView.setAnimation("data.json");
        animationView.loop(true);
        animationView.playAnimation();
        // 任何符合颜色过滤界面的类
//        final PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED,
//                PorterDuff.Mode.LIGHTEN);
//
//// 在整个视图中添加一个颜色过滤器
//        animationView.addColorFilter(colorFilter);
//        Cancellable compositionCancellable = LottieComposition.Factory.fromJson(getResources(),
//                jsonObject, (composition) -> {
//                    animationView.setComposition(composition);
//                    animationView.playAnimation();
//                });
    }

    /**
     * @param animationView
     * @param view          关闭加载动画
     */
    protected void releaseAnimation(LottieAnimationView animationView, View view) {
        animationView.cancelAnimation();
        animationView.clearAnimation();
        if (view != null) {
            view.setVisibility(View.GONE);
        }
    }
}
