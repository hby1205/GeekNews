package com.example.geeknews.geeknews.base;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {

    private List<BaseModel> mList = new ArrayList<>();

    protected M myModel;
    protected V myView;

    public void addModel(M myModel) {
        this.myModel = myModel;
        mList.add(myModel);
    }

    public void addView(V myView) {
        this.myView = myView;
    }

    public void destroy() {
        if (myView != null) {
            myView = null;
        }

        if (mList.size() > 0 && mList != null) {
            for (BaseModel baseModel : mList) {
                baseModel.clear();
            }
        }
        if (myModel != null) {
            myModel = null;
        }
    }
}
