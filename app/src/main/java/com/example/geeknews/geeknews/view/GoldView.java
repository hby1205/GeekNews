package com.example.geeknews.geeknews.view;

import com.example.geeknews.geeknews.base.BaseView;
import com.example.geeknews.geeknews.bean.GoldBean;

public interface GoldView extends BaseView {
    void onSuccess(GoldBean goldBean);

    void onError(String error);

}
