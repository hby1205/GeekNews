package com.example.geeknews.geeknews.api;

import com.example.geeknews.geeknews.bean.RiBaoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RiBaoServer {

    public String URL = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<RiBaoBean> getData();
}
