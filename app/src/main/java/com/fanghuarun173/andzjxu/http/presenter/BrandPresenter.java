package com.fanghuarun173.andzjxu.http.presenter;

import com.fanghuarun173.andzjxu.http.HttpMethods;
import com.fanghuarun173.andzjxu.http.entity.BrandEntity;
import com.fanghuarun173.andzjxu.http.entity.HttpResult;

import java.util.List;


import rx.Observable;
import rx.Subscriber;

public class BrandPresenter extends HttpMethods {

    public static void getBrandList(Subscriber<List<BrandEntity>> subscriber){
        Observable<List<BrandEntity>> observable = brandService.getBrandList()
                .map(new HttpResultFunc<List<BrandEntity>>());
        toSubscribe(observable,subscriber);
    }
}
