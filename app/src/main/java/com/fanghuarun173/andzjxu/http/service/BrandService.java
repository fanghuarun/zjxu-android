package com.fanghuarun173.andzjxu.http.service;
import com.fanghuarun173.andzjxu.http.entity.BrandEntity;
import com.fanghuarun173.andzjxu.http.entity.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface BrandService {

    @GET("brand/disabled")
    public  Observable<HttpResult<List<BrandEntity>>> getBrandList();

}
