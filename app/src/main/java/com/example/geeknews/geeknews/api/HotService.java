package com.example.geeknews.geeknews.api;

import com.example.geeknews.geeknews.bean.HotBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface HotService {
//    http://news-at.zhihu.com/api/4/news/hot
    public String URL ="http://news-at.zhihu.com/api/4/";

    @GET("news/hot")
    Observable<HotBean> getData();
}
