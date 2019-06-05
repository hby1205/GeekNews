package com.example.geeknews.geeknews.model;

import com.example.geeknews.geeknews.api.RiBaoServer;
import com.example.geeknews.geeknews.base.BaseCallBack;
import com.example.geeknews.geeknews.base.BaseModel;
import com.example.geeknews.geeknews.bean.RiBaoBean;
import com.example.geeknews.geeknews.net.BaseObserver;
import com.example.geeknews.geeknews.net.HttpUtils;
import com.example.geeknews.geeknews.net.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;

public class RiBaoModel extends BaseModel {

    public void riBaoData(final BaseCallBack<RiBaoBean> callBack) {
        RiBaoServer server = HttpUtils.getInstance().getData(RiBaoServer.URL, RiBaoServer.class);

        Observable<RiBaoBean> data = server.getData();


        data.compose(RxUtils.<RiBaoBean>getObservable())
                .subscribe(new BaseObserver<RiBaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(RiBaoBean riBaoBean) {
                        if (riBaoBean != null) {
                            List<RiBaoBean.StoriesBean> stories = riBaoBean.getStories();
                            List<RiBaoBean.TopStoriesBean> top_stories = riBaoBean.getTop_stories();
                            if (stories.size() > 0 && top_stories.size() > 0 && stories != null && top_stories != null) {
                                callBack.onSuccess(riBaoBean);
                            } else {
                                callBack.onError("数据为空");
                            }
                        } else {
                            callBack.onError("数据请求失败");
                        }
                    }
                });
    }
}
