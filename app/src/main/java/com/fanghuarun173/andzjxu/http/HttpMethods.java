package com.fanghuarun173.andzjxu.http;

import android.util.Log;

import com.fanghuarun173.andzjxu.common.Constants;
import com.fanghuarun173.andzjxu.http.entity.GoodsEntity;
import com.fanghuarun173.andzjxu.http.entity.HttpResult;
import com.fanghuarun173.andzjxu.http.service.BrandService;
import com.fanghuarun173.andzjxu.http.service.CategoryService;
import com.fanghuarun173.andzjxu.http.service.GoodsService;
import com.fanghuarun173.andzjxu.http.service.MemberService;

import java.sql.Time;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HttpMethods {

    private static final  String TAG ="HttpMethods";

    private static final  String BASE_URL= Constants.BASE_URL;
    private  static final long DEFAULT_TIMEOUT=5;
    private static HttpMethods sInstance=getInstance();
    protected static GoodsService goodsService;
    protected static MemberService memberService;
    protected  static CategoryService categoryService;
    protected  static BrandService brandService;
    private Retrofit retrofit;

    public HttpMethods(){
        if(sInstance == null){
            OkHttpClient okHttpClient=new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                    .build();
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

            goodsService=retrofit.create(GoodsService.class);
            memberService=retrofit.create(MemberService.class);
            categoryService=retrofit.create(CategoryService.class);
            brandService=retrofit.create(BrandService.class);

        }

    }

    public static HttpMethods getInstance(){
        if(sInstance == null){
            synchronized (HttpMethods.class){
                if(sInstance == null){
                    sInstance=new HttpMethods();
                }
            }
        }
        return sInstance;
    }


    public static class HttpResultFunc<T> implements Func1<HttpResult<T>,T>{


        @Override
        public T call(HttpResult<T> tHttpResult) {
            Log.i(TAG,"status:"+tHttpResult.getStatus());
            Log.i(TAG,"msg:"+tHttpResult.getMsg());
            Log.i(TAG,"data:"+tHttpResult.getData());
            return tHttpResult.getData();
        }
    }

    protected  static <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
