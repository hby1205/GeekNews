package com.example.geeknews.geeknews.base;

public interface BaseCallBack<T> {
    // 因为不知道成功之后什么类型，所以给个泛型
    void onSuccess(T t);
    void onError(String error);
}
