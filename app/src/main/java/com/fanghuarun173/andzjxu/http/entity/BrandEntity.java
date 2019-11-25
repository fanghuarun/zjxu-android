package com.fanghuarun173.andzjxu.http.entity;

import android.content.Intent;

import java.io.Serializable;

public class BrandEntity implements Serializable {
    public Integer brand_id;
    public String name;
    public String logo;
    public String keywords;
    public String description;
    public String url;
    public Integer disabled;
    public Long createime;
    public Long modifytime;

    @Override
    public String toString() {
        return "BrandEntity{" +
                "brand_id=" + brand_id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", disabled=" + disabled +
                ", createime=" + createime +
                ", modifytime=" + modifytime +
                '}';
    }
}
