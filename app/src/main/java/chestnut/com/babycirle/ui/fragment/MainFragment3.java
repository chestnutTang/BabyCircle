package chestnut.com.babycirle.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import chestnut.com.babycirle.R;


public class MainFragment3 extends BaseFragment {
//    @BindView(R.id.plus_one_button)
//    PlusOneButton plusOneButton;
    @BindView(R.id.txt_name)
    TextView txtName;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, super.onCreateView(inflater, container,
                savedInstanceState));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plus_one3;
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
