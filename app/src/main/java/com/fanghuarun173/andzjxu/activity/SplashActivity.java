package com.fanghuarun173.andzjxu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.fanghuarun173.andzjxu.R;
import com.fanghuarun173.andzjxu.common.BaseActivity;

public class SplashActivity extends BaseActivity {
    //引导页


    ImageView splash_loading_item;

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void initView() {
        super.initView();
        splash_loading_item=(ImageView)findViewById(R.id.splash_loading_item);
        Animation translate= AnimationUtils.loadAnimation(this,R.anim.splash_loading);
        translate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this,AdActivity.class));
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        splash_loading_item.setAnimation(translate);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }
}
