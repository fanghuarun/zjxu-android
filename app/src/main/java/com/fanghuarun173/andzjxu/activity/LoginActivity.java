package com.fanghuarun173.andzjxu.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fanghuarun173.andzjxu.R;
import com.fanghuarun173.andzjxu.common.BaseActivity;
import com.fanghuarun173.andzjxu.http.entity.MemberEntity;
import com.fanghuarun173.andzjxu.http.presenter.MemberPresenter;

import java.util.ArrayList;

import rx.Subscriber;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private static String TAG="login";

    private EditText usernameEdit;
    private EditText passwordEdit;

    private Button loginBt;
    private ImageView backImg;


    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        usernameEdit=findViewById(R.id.et_username);
        passwordEdit=findViewById(R.id.et_password);

        loginBt=findViewById(R.id.bt_login);
        backImg=findViewById(R.id.login_in_image);

        String username=getIntent().getStringExtra("username");
        usernameEdit.setText(username);

        loginBt.setOnClickListener(this);
        backImg.setOnClickListener(this);
    }


    private void login(){
        String username=usernameEdit.getText().toString();
        String password=passwordEdit.getText().toString();
        ArrayList<String> errors=new ArrayList<String>();
        if(username.isEmpty()){
            errors.add("账户不能为空");
        }
        if(password.isEmpty()){
            errors.add("密码不能为空");
        }
        StringBuilder builder=new StringBuilder();
        if(errors.isEmpty()){

            MemberPresenter.login(new Subscriber< MemberEntity>(){

                @Override
                public void onCompleted() {
//                    finish();
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG,e.getMessage());
                    Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_SHORT);
                }

                @Override
                public void onNext(MemberEntity memberEntity) {
                    Intent intent =new Intent(LoginActivity.this,NetWorkActivity.class);
                    intent.putExtra("userInfo",memberEntity);
                    Log.d(TAG,memberEntity.toString());
                    startActivity(intent);
                    finish();
                }
            },username,password);

        }else{
            for(String error:errors){
                builder.append(error+"\n");
            }
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage(builder.toString())
                    .show();
        }
        Log.d(TAG,builder.toString());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:

                login();
                Log.d(TAG,"logined");
                break;
            case R.id.login_in_image:
                finish();
                break;
        }
    }
}
