package com.example.geeknews.geeknews.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.geeknews.geeknews.R;
import com.example.geeknews.geeknews.adapter.VpZhiHuAdapter;
import com.example.geeknews.geeknews.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class ZhiHuFragment extends BaseFragment {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Integer> mTitles;

    @Override
    protected int getLaoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new RiBaoFragment());
        mFragments.add(new ThemeFragment());
        mFragments.add(new HotFragment());
        mTitles = new ArrayList<>();
        mTitles.add(R.string.ribao);
        mTitles.add(R.string.theme);
        mTitles.add(R.string.hot);

        VpZhiHuAdapter vpZhiHuAdapter = new VpZhiHuAdapter(getChildFragmentManager(), mTitles, mFragments, getActivity());
        vp.setAdapter(vpZhiHuAdapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initListener() {
        super.initListener();
    }
}
