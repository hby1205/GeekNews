package com.example.geeknews.geeknews.net;

import com.example.geeknews.geeknews.utils.ToastUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onError(Throwable e) {
        ToastUtil.showShort(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
