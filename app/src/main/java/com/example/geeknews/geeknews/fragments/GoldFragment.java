package com.example.geeknews.geeknews.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.geeknews.geeknews.GoldActivity;
import com.example.geeknews.geeknews.R;
import com.example.geeknews.geeknews.adapter.VpGoldAdapter;
import com.example.geeknews.geeknews.base.BaseFragment;
import com.example.geeknews.geeknews.bean.GoldItemTitleBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GoldFragment extends BaseFragment {

    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private String[] mTypes = new String[]{"Android", "iOS", "休息视频", "福利", "前端", "all"};
    private ArrayList<Fragment> mFragments;
    private ArrayList<GoldItemTitleBean> list;
    private ArrayList<String> titles;

    @Override
    protected int getLaoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView() {
        mFragments = new ArrayList<>();

        list = new ArrayList<>();

        titles = new ArrayList<>();

        for (int i = 0; i < mTypes.length; i++) {
            String name = mTypes[i];
            if (i % 3 == 0) {
                list.add(new GoldItemTitleBean(name, true));
            } else {
                list.add(new GoldItemTitleBean(name, false));
            }
        }
    }

    @Override
    protected void initData() {
        for (int i = 0; i < list.size(); i++) {
            GoldItemTitleBean goldItemTitleBean = list.get(i);
            if (goldItemTitleBean.isSelected()) {
                GoldItemFragment goldItemFragment = new GoldItemFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", goldItemTitleBean.getName());
                goldItemFragment.setArguments(bundle);
                titles.add(goldItemTitleBean.getName());
                mFragments.add(goldItemFragment);
            }
        }
        VpGoldAdapter vpGoldAdapter = new VpGoldAdapter(getChildFragmentManager(), titles, mFragments);
        vp.setAdapter(vpGoldAdapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initListener() {
        ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),GoldActivity.class);
                intent.putParcelableArrayListExtra("list", list);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            list = data.getParcelableArrayListExtra("list");

            mFragments.clear();
            titles.clear();
            initData();
        }
    }
}
