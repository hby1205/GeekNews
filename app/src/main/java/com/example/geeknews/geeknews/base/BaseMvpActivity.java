package com.example.geeknews.geeknews.base;

public abstract class BaseMvpActivity<M extends BaseModel,V extends BaseView,P extends BasePresenter>  extends BaseActivity{

    protected  P myPresenter;
    @Override
    protected void initMvp() {
        myPresenter = initMvpPresenter();
        if (myPresenter!=null){
            myPresenter.addModel(initMvpModel());
            myPresenter.addView(initMvpView());
        }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myPresenter !=null){
            myPresenter =null;
            myPresenter.destroy();
        }
    }
}
