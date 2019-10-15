package com.fanghuarun173.test3.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initView();
        initData();
    }

    @LayoutRes
    public abstract int getContentViewId();
    protected  void initData(){};
    protected   void initView(){};
    public void toastLong(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    public void toastShort(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
