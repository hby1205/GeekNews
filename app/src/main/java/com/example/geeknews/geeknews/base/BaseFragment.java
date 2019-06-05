package com.example.geeknews.geeknews.base;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLaoutId(), container, false);
        mBind = ButterKnife.bind(this, inflate);

        initMvp();
        initView();
        initData();
        initListener();
        return inflate;
    }

    protected void initListener() {

    }

    protected void initData() {
    }

    protected void initView() {

    }

    protected void initMvp() {

    }

    protected abstract int getLaoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }
}
