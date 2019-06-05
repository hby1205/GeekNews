package com.example.geeknews.geeknews.view;

import com.example.geeknews.geeknews.base.BaseView;
import com.example.geeknews.geeknews.bean.HotBean;

public interface HotView extends BaseView {
    void onError(String error);

    void onSuccess(HotBean hotBean);
}
