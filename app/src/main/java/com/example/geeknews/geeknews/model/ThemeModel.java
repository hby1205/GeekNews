package com.example.geeknews.geeknews.model;

import com.example.geeknews.geeknews.api.ThemeService;
import com.example.geeknews.geeknews.base.BaseCallBack;
import com.example.geeknews.geeknews.base.BaseModel;
import com.example.geeknews.geeknews.bean.ThemeBean;
import com.example.geeknews.geeknews.net.BaseObserver;
import com.example.geeknews.geeknews.net.HttpUtils;
import com.example.geeknews.geeknews.net.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ThemeModel extends BaseModel {

    public  void getData(final BaseCallBack<ThemeBean> callBack){


        ThemeService service =  HttpUtils.getInstance().getData(ThemeService.URL, ThemeService.class);

        Observable<ThemeBean> data = service.getData();

        data.compose(RxUtils.<ThemeBean>getObservable())
                .subscribe(new BaseObserver<ThemeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ThemeBean themeBean) {
                        if (themeBean!=null){
                            List<ThemeBean.DataBean> data1 = themeBean.getData();
                            if (data1.size()>0 &&data1!=null){
                                callBack.onSuccess(themeBean);
                            }else{
                                callBack.onError("数据错误");
                            }
                        }else{

                                callBack.onError("数据错误");
                        }
                    }
                });
    }
}
