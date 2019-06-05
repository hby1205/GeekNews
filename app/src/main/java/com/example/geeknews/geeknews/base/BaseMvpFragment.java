package com.example.geeknews.geeknews.base;

public abstract class BaseMvpFragment<M extends BaseModel, V extends BaseView, P extends BasePresenter> extends BaseFragment {

    protected P myPresenter;

    @Override
    protected void initMvp() {
        super.initMvp();
        myPresenter = initMvpPresenter();
        if (myPresenter != null) {
            myPresenter.addView(initMvpView());
            myPresenter.addModel(initMvpModel());
        }
    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (myPresenter != null) {
            myPresenter.destroy();
            myPresenter = null;
        }
    }
}
