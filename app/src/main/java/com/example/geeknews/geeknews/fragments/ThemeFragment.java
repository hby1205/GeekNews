package com.example.geeknews.geeknews.fragments;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.geeknews.R;
import com.example.geeknews.geeknews.adapter.ThemeAdapter;
import com.example.geeknews.geeknews.base.BaseMvpFragment;
import com.example.geeknews.geeknews.bean.ThemeBean;
import com.example.geeknews.geeknews.model.ThemeModel;
import com.example.geeknews.geeknews.presenter.ThemePresenter;
import com.example.geeknews.geeknews.utils.ToastUtil;
import com.example.geeknews.geeknews.view.ThemeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ThemeFragment extends BaseMvpFragment<ThemeModel, ThemeView, ThemePresenter> implements ThemeView {

    @BindView(R.id.xcl)
    RecyclerView xcl;
    Unbinder unbinder;
    private ThemeAdapter mThemeAdapter;

    @Override
    protected int getLaoutId() {
        return R.layout.fragment_theme;
    }

    @Override
    protected ThemeModel initMvpModel() {
        return new ThemeModel();
    }

    @Override
    protected ThemeView initMvpView() {
        return this;
    }

    @Override
    protected ThemePresenter initMvpPresenter() {
        return new ThemePresenter();
    }

    @Override
    public void onSuccess(ThemeBean themeBean) {
        if (themeBean != null) {
            List<ThemeBean.DataBean> data = themeBean.getData();
            mThemeAdapter.addUI(data);
        }
    }

    @Override
    public void onError(String error) {
        ToastUtil.showShort(error);
    }

    @Override
    protected void initView() {
        xcl.setLayoutManager(new LinearLayoutManager(getActivity()));
        xcl.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mThemeAdapter = new ThemeAdapter(getActivity());
        xcl.setAdapter(mThemeAdapter);

    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }

}
