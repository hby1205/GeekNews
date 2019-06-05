package com.example.geeknews.geeknews.presenter;

import com.example.geeknews.geeknews.base.BaseCallBack;
import com.example.geeknews.geeknews.base.BasePresenter;
import com.example.geeknews.geeknews.bean.HotBean;
import com.example.geeknews.geeknews.model.HotModel;
import com.example.geeknews.geeknews.view.HotView;

public class HotPresenter extends BasePresenter<HotModel,HotView> {

    public void getData(){
        if (myModel!=null){
            myModel.getData(new BaseCallBack<HotBean>() {
                @Override
                public void onSuccess(HotBean hotBean) {
                    if (myView!=null){
                        myView.onSuccess(hotBean);
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
