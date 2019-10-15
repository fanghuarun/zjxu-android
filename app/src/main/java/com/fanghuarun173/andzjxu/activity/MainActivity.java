package com.fanghuarun173.andzjxu.activity;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.fanghuarun173.andzjxu.R;
import com.fanghuarun173.andzjxu.common.BaseActivity;
import com.fanghuarun173.andzjxu.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {


    @Override
    @LayoutRes
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        super.initView();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main,new NavigationFragment());
        fragmentTransaction.commit();

    }
}
