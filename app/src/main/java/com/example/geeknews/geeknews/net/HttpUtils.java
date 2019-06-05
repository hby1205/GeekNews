package com.example.geeknews.geeknews.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    private final Retrofit.Builder mBuilder;

    private HttpUtils() {
        mBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    }

    private static HttpUtils mHttpUtils;

    public static HttpUtils getInstance() {
        if (mHttpUtils == null) {
            synchronized (HttpUtils.class) {
                if (mHttpUtils == null) {
                    mHttpUtils = new HttpUtils();
                }
            }
        }
        return mHttpUtils;
    }

    public <T> T getData(String baseUrl, Class<T> mClass) {
        return mBuilder.baseUrl(baseUrl).build().create(mClass);
    }
}
