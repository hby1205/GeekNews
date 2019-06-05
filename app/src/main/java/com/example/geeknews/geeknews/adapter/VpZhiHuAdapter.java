package com.example.geeknews.geeknews.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class VpZhiHuAdapter extends FragmentPagerAdapter {
    private List<Integer> mTitles;
    private List<Fragment> mFragments;
    private Context mContext;

    public VpZhiHuAdapter(FragmentManager fm, List<Integer> titles, List<Fragment> fragments, Context context) {
        super(fm);
        mTitles = titles;
        mFragments = fragments;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(mTitles.get(position));
    }
}
