package com.example.geeknews.geeknews.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

public class FragmentUtils {

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> mClass, int layoutId) {
        addFragment(manager, mClass, layoutId, null, false);
    }

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> mClass, int layoutId, Bundle bundle) {
        addFragment(manager, mClass, layoutId, bundle, false);
    }

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> mClass, int layoutId, Bundle bundle, boolean isNeedToBackStack) {
        String tag = mClass.getName();

        Fragment fragment = manager.findFragmentByTag(tag);
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment == null) {
            try {
                fragment = mClass.newInstance();
                fragment.setArguments(bundle);

                transaction.add(layoutId, fragment, tag);
                hideOtherFragment(manager, transaction, fragment);
                if (isNeedToBackStack) {
                    transaction.addToBackStack(tag);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        } else {

            if (fragment.isAdded()) {

                if (fragment.isHidden()) {
                    fragment.setArguments(bundle);
                    transaction.show(fragment);
                    hideOtherFragment(manager, transaction, fragment);
                }



            } else {
                fragment.setArguments(bundle);

                transaction.add(layoutId, fragment, tag);
                hideOtherFragment(manager, transaction, fragment);
            }
        }
        transaction.commit();


    }

    private static void hideOtherFragment(FragmentManager manager, FragmentTransaction transaction, Fragment willFragment) {
        List<Fragment> fragments = manager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != willFragment && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
    }
}
