package com.example.geeknews.geeknews.api;

import com.example.geeknews.geeknews.bean.ThemeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ThemeService {
//    http://news-at.zhihu.com/api/4/sections
    public String URL =" http://news-at.zhihu.com/api/ ";

    @GET("4/sections")
    Observable<ThemeBean> getData();
}
