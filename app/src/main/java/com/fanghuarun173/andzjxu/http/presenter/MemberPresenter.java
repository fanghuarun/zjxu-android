package com.fanghuarun173.andzjxu.http.presenter;

import com.fanghuarun173.andzjxu.http.HttpMethods;
import com.fanghuarun173.andzjxu.http.entity.MemberEntity;

import java.lang.reflect.Member;

import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods {

    public static void register(Subscriber<MemberEntity>subscriber,String username,String email,String password){
        Observable observable=memberService.register(username,password,email)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }

    public static void login(Subscriber<MemberEntity> subscriber,String username,String password){
        Observable observable=memberService.login2(username,password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);


    }

    public static void changePassword(Subscriber subscriber,String memeberId,String old_pwd,String new_pwd){
        Observable observable=memberService.changePassword(memeberId,old_pwd,new_pwd);
        toSubscribe(observable,subscriber);
    }
}
