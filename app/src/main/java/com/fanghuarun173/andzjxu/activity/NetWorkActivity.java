package com.fanghuarun173.andzjxu.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fanghuarun173.andzjxu.R;
import com.fanghuarun173.andzjxu.common.BaseActivity;
import com.fanghuarun173.andzjxu.http.entity.MemberEntity;
import com.fanghuarun173.andzjxu.http.entity.MemberResult;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetWorkActivity extends BaseActivity implements View.OnClickListener {


    private TextView tv_result;
    private MemberEntity userInfo;

    @Override
    protected void initData() {
        super.initData();
        userInfo=(MemberEntity)getIntent().getExtras().get("userInfo");
        tv_result.setText(userInfo.toString());
    }

    @Override
    protected void initView() {
        super.initView();
        tv_result=(TextView)findViewById(R.id.tv_result);
//
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_net_work;
    }

    @Override
    public void onClick(View v) {


    }

//    public void httpRequest(final String username ,final String password){
//        new Thread(){
//            @Override
//            public void run() {
//                OkHttpClient client=new OkHttpClient();
//                FormBody body =new FormBody.Builder()
//                        .add("input",username)
//                        .add("password",password)
//                        .build();
//                Request request=new Request.Builder()
//                        .url(requestUrl)
//                        .post(body)
//                        .build();
//                try{
//                    Response response=client.newCall(request).execute();
//
//                    String result=response.body().string();
//                    Gson gson=new Gson();
//                    final MemberResult memberResult=gson.fromJson(result,MemberResult.class);
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            if(memberResult !=null && memberResult.data != null){
//                                tv_result.setText(
//                                        String.format("用户名:%s\n邮箱:%s",memberResult.data.uname,memberResult.data.email)
//                                );
//                            }
//                        }
//                    });
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }
}
