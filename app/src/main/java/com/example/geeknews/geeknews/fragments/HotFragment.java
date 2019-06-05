package com.example.geeknews.geeknews.fragments;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.geeknews.R;
import com.example.geeknews.geeknews.adapter.HotAdapter;
import com.example.geeknews.geeknews.base.BaseMvpFragment;
import com.example.geeknews.geeknews.bean.HotBean;
import com.example.geeknews.geeknews.model.HotModel;
import com.example.geeknews.geeknews.presenter.HotPresenter;
import com.example.geeknews.geeknews.utils.ToastUtil;
import com.example.geeknews.geeknews.view.HotView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HotFragment extends BaseMvpFragment<HotModel, HotView, HotPresenter> implements HotView {
    @BindView(R.id.xcl)
    RecyclerView xcl;
    private HotAdapter mHotAdapter;

    @Override
    protected int getLaoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected HotModel initMvpModel() {
        return new HotModel();
    }

    @Override
    protected HotView initMvpView() {
        return this;
    }

    @Override
    protected HotPresenter initMvpPresenter() {
        return new HotPresenter();
    }

    @Override
    public void onError(String error) {
        ToastUtil.showShort(error);
    }

    @Override
    public void onSuccess(HotBean hotBean) {
        if (hotBean != null) {
            List<HotBean.RecentBean> recent = hotBean.getRecent();
            mHotAdapter.addUI(recent);
        }
    }

    @Override
    protected void initView() {
        xcl.setLayoutManager(new LinearLayoutManager(getActivity()));
        xcl.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mHotAdapter = new HotAdapter(getActivity());
        xcl.setAdapter(mHotAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }

}
