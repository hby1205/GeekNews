package com.example.geeknews.geeknews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.geeknews.geeknews.base.BaseActivity;
import com.example.geeknews.geeknews.fragments.AboutFragment;
import com.example.geeknews.geeknews.fragments.CollectFragment;
import com.example.geeknews.geeknews.fragments.GankFragment;
import com.example.geeknews.geeknews.fragments.GoldFragment;
import com.example.geeknews.geeknews.fragments.SettingFragment;
import com.example.geeknews.geeknews.fragments.VtexFragment;
import com.example.geeknews.geeknews.fragments.WeChatFragment;
import com.example.geeknews.geeknews.fragments.ZhiHuFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_ABOUT;
import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_COLLECT;
import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_GANK;
import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_GOLD;
import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_SETTING;
import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_VTEX;
import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_WECHAT;
import static com.example.geeknews.geeknews.utils.AppConstants.TYPE_ZHIHU;

//郝博渊
public class MainActivity extends BaseActivity {

    @BindView(R.id.too)
    Toolbar too;
    @BindView(R.id.fram)
    FrameLayout fram;
    @BindView(R.id.na_show)
    NavigationView naShow;
    @BindView(R.id.draw)
    DrawerLayout draw;
    private List<Integer> mTitles;
    private ArrayList<Fragment> mFragments;
    private FragmentManager mManager;
    private int mLastType = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initTitles();
        initFragment();
        too.setTitle(mTitles.get(0));
        setSupportActionBar(too);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, draw, too, R.string.app_name, R.string.app_name);
        draw.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        mManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mManager.beginTransaction();
        fragmentTransaction.add(R.id.fram,mFragments.get(mLastType));
        fragmentTransaction.commit();
    }

    @Override
    protected void initListener() {
        naShow.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 点击的时候，选中
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.zhihu:
                        switchTitleAndFragment(TYPE_ZHIHU);
                        break;
                    case R.id.wechat:
                        switchTitleAndFragment(TYPE_WECHAT);
                        break;
                    case R.id.gank:
                        switchTitleAndFragment(TYPE_GANK);
                        break;
                    case R.id.gold:
                        switchTitleAndFragment(TYPE_GOLD);
                        break;
                    case R.id.vtex:
                        switchTitleAndFragment(TYPE_VTEX);
                        break;
                    case R.id.collect:
                        switchTitleAndFragment(TYPE_COLLECT);
                        break;
                    case R.id.setting:
                        switchTitleAndFragment(TYPE_SETTING);
                        break;
                    case R.id.about:
                        switchTitleAndFragment(TYPE_ABOUT);
                        break;
                }
                draw.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }

    private void switchTitleAndFragment(int type) {
        FragmentTransaction fragmentTransaction = mManager.beginTransaction();

        Fragment fragment = mFragments.get(type);
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.fram, fragment);
        }

        fragmentTransaction.hide(mFragments.get(mLastType));
        fragmentTransaction.show(fragment);

        fragmentTransaction.commit();

        mLastType = type;

        too.setTitle(getResources().getString(mTitles.get(type)));
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(R.string.zhihu);
        mTitles.add(R.string.wechat);
        mTitles.add(R.string.gank);
        mTitles.add(R.string.gold);
        mTitles.add(R.string.vtex);
        mTitles.add(R.string.collect);
        mTitles.add(R.string.setting);
        mTitles.add(R.string.about);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new ZhiHuFragment());
        mFragments.add(new WeChatFragment());
        mFragments.add(new GankFragment());
        mFragments.add(new GoldFragment());
        mFragments.add(new VtexFragment());
        mFragments.add(new CollectFragment());
        mFragments.add(new SettingFragment());
        mFragments.add(new AboutFragment());
    }
}