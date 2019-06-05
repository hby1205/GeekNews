package com.example.geeknews.geeknews.presenter;

import com.example.geeknews.geeknews.base.BaseCallBack;
import com.example.geeknews.geeknews.base.BasePresenter;
import com.example.geeknews.geeknews.bean.ThemeBean;
import com.example.geeknews.geeknews.model.ThemeModel;
import com.example.geeknews.geeknews.view.ThemeView;

public class ThemePresenter extends BasePresenter<ThemeModel,ThemeView> {

    public void getData(){
        if (myModel!=null){
            myModel.getData(new BaseCallBack<ThemeBean>() {
                @Override
                public void onSuccess(ThemeBean themeBean) {
                    if (myView!=null){
                        myView.onSuccess(themeBean);
                    }
                }

                @Override
                public void onError(String error) {
                    if (myView!=null){
                        myView.onError(error);
                    }
                }
            });
        }
    }
}
