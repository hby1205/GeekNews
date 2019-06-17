package com.example.geeknews.geeknews.model;

import com.example.geeknews.geeknews.api.AndroidServer;
import com.example.geeknews.geeknews.base.BaseCallBack;
import com.example.geeknews.geeknews.base.BaseModel;
import com.example.geeknews.geeknews.bean.GoldBean;
import com.example.geeknews.geeknews.net.BaseObserver;
import com.example.geeknews.geeknews.net.HttpUtils;
import com.example.geeknews.geeknews.net.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class GoldModel extends BaseModel {

    public void getGoldData(final BaseCallBack<GoldBean> callBack, String tech, int num, int page) {
        HttpUtils instance = HttpUtils.getInstance();

        AndroidServer server = instance.getData(AndroidServer.URL, AndroidServer.class);
        Observable<GoldBean> data = server.getData(tech, num, page);

        data.compose(RxUtils.<GoldBean>getObservable())
                .subscribe(new BaseObserver<GoldBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(GoldBean goldBean) {
                        if (goldBean != null) {
                            List<GoldBean.ResultsBean> results = goldBean.getResults();
                            if (results != null && results.size() > 0) {
                                callBack.onSuccess(goldBean);
                            } else {
                                callBack.onError("数据为空");
                            }
                        } else {
                            callBack.onError("数据为空");
                        }
                    }
                });
    }

}
