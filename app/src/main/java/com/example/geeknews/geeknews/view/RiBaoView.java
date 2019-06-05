package com.example.geeknews.geeknews.view;

import com.example.geeknews.geeknews.base.BaseView;
import com.example.geeknews.geeknews.bean.RiBaoBean;

public interface RiBaoView extends BaseView {
    void onError(String error);

    void onSuccess(RiBaoBean riBaoBean);
}
