package com.titlezwc.moment.presentation.proxy.impl;

import android.content.res.Configuration;

import com.titlezwc.moment.common.application.BaseApplication;
import com.titlezwc.moment.common.application.proxy.listener.ApplicationProxyListener;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class ApplicationProxyImpl implements ApplicationProxyListener {
    private final BaseApplication mApplication;

    public ApplicationProxyImpl(BaseApplication application) {
        mApplication = application;
    }

    @Override
    public void onCreate(String processName) {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }
}
