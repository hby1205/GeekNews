package com.example.geeknews.geeknews.presenter;


import com.example.geeknews.geeknews.base.BaseCallBack;
import com.example.geeknews.geeknews.base.BaseModel;
import com.example.geeknews.geeknews.base.BasePresenter;
import com.example.geeknews.geeknews.bean.RiBaoBean;
import com.example.geeknews.geeknews.model.RiBaoModel;
import com.example.geeknews.geeknews.view.RiBaoView;

public class RiBaoPresenter extends BasePresenter<RiBaoModel,RiBaoView> {


    public void getData(){
        if (myModel!=null){
            myModel.riBaoData(new BaseCallBack<RiBaoBean>() {
                @Override
                public void onSuccess(RiBaoBean riBaoBean) {
                    if (myView!=null){
                        myView.onSuccess(riBaoBean);
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
