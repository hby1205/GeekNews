package com.example.geeknews.geeknews.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {

    protected  CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    public void clear(){
        mCompositeDisposable.clear();
    }
}
