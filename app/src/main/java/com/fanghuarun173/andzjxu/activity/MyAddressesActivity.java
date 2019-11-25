package com.fanghuarun173.andzjxu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fanghuarun173.andzjxu.R;
import com.fanghuarun173.andzjxu.common.BaseActivity;

import butterknife.BindView;

public class MyAddressesActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getContentViewId() { return R.layout.activity_my_addresses; }

    @Override
    protected void initView() {
        super.initView();
        tvTitle=findViewById(R.id.tv_title);
        tvTitle.setText("我的地址");

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
    }

    //    @OnClick(R.id.iv_back)
    void close(){ finish();}
}
