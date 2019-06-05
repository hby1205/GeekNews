package com.example.geeknews.geeknews.view;

import com.example.geeknews.geeknews.base.BaseView;
import com.example.geeknews.geeknews.bean.ThemeBean;

public interface ThemeView extends BaseView {

    void onSuccess(ThemeBean themeBean);

    void onError(String error);
}
