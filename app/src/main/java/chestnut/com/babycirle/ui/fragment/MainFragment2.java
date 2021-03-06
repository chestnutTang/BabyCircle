package chestnut.com.babycirle.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;

import butterknife.BindView;
import chestnut.com.babycirle.R;


public class MainFragment2 extends BaseFragment {
//    @BindView(R.id.plus_one_button)
//    PlusOneButton plusOneButton;
    @BindView(R.id.txt_name)
    TextView txtName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plus_one2;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setTitle(String title) {
        txtName.setText(title);
    }
}
