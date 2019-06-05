package com.example.geeknews.geeknews.model;

import com.example.geeknews.geeknews.api.HotService;
import com.example.geeknews.geeknews.base.BaseCallBack;
import com.example.geeknews.geeknews.base.BaseModel;
import com.example.geeknews.geeknews.bean.HotBean;
import com.example.geeknews.geeknews.net.BaseObserver;
import com.example.geeknews.geeknews.net.HttpUtils;
import com.example.geeknews.geeknews.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class HotModel extends BaseModel {

    public void getData(final BaseCallBack<HotBean> callBack) {
        HttpUtils instance = HttpUtils.getInstance();

        HotService data = instance.getData(HotService.URL, HotService.class);
        Observable<HotBean> data1 = data.getData();

        data1.compose(RxUtils.<HotBean>getObservable())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        if (hotBean != null) {
                            if (hotBean.getRecent().size() > 0 && hotBean.getRecent() != null) {
                                callBack.onSuccess(hotBean);
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
