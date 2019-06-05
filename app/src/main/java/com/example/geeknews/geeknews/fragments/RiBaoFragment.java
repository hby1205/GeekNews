package com.example.geeknews.geeknews.fragments;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.geeknews.R;
import com.example.geeknews.geeknews.adapter.XclMyAdapter;
import com.example.geeknews.geeknews.base.BaseFragment;
import com.example.geeknews.geeknews.base.BaseMvpFragment;
import com.example.geeknews.geeknews.bean.RiBaoBean;
import com.example.geeknews.geeknews.model.RiBaoModel;
import com.example.geeknews.geeknews.presenter.RiBaoPresenter;
import com.example.geeknews.geeknews.utils.ToastUtil;
import com.example.geeknews.geeknews.view.RiBaoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RiBaoFragment extends BaseMvpFragment<RiBaoModel,RiBaoView,RiBaoPresenter> implements RiBaoView {
    @BindView(R.id.xcl)
    RecyclerView xcl;
    private XclMyAdapter mXclMyAdapter;

    @Override
    protected int getLaoutId() {
        return R.layout.ribao;
    }



    @Override
    protected RiBaoModel initMvpModel() {
        return new RiBaoModel();
    }

    @Override
    protected RiBaoView initMvpView() {
        return this;
    }

    @Override
    protected RiBaoPresenter initMvpPresenter() {
        return new RiBaoPresenter();
    }

    @Override
    protected void initView() {
        xcl.setLayoutManager(new LinearLayoutManager(getActivity()));
        xcl.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mXclMyAdapter = new XclMyAdapter(getActivity());
        xcl.setAdapter(mXclMyAdapter);

    }

    @Override
    protected void initData() {
        myPresenter.getData();
    }

    @Override
    public void onError(String error) {
        ToastUtil.showShort(error);
    }

    @Override
    public void onSuccess(RiBaoBean riBaoBean) {
        mXclMyAdapter.addBannerUI(riBaoBean.getTop_stories());
        mXclMyAdapter.addUI(riBaoBean.getStories());
    }
}
