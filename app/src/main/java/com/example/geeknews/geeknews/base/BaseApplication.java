package com.example.geeknews.geeknews.base;

import android.app.Application;

public class BaseApplication extends Application {
    private static volatile BaseApplication mBaseApplication;

    public static BaseApplication getBaseApplication() {
        if (mBaseApplication == null) {
            synchronized (BaseApplication.class) {
                if (mBaseApplication == null) {
                    mBaseApplication = new BaseApplication();
                }
            }
        }
        return mBaseApplication;
    }
}
