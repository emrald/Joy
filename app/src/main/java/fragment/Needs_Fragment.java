package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;
import android.support.v4.app.Fragment;

import com.example.abc.joy23final.R;

/**
 * Created by Abc on 05/05/2017.
 */
public class Needs_Fragment extends Fragment {

    ImageView mBackdrop;
    AppBarLayout mAppbar;
    CollapsingToolbarLayout mCollapsingToolbar;
    Toolbar mToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.needs_design, container, false);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
