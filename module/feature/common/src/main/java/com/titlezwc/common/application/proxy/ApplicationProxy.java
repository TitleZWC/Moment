package com.titlezwc.common.application.proxy;

import android.content.res.Configuration;

import com.titlezwc.common.application.proxy.listener.ApplicationProxyListener;
import com.titlezwc.log.LogUtils;

import javax.inject.Inject;

import dagger.internal.Preconditions;

/**
 * Created by TitleZWC on 2016/12/8.
 */

public class ApplicationProxy implements ApplicationProxyListener {

    private ApplicationProxyListener mApplicationProxyListener;

    @Inject
    public ApplicationProxy(ApplicationProxyListener applicationProxyListener) {
        LogUtils.d("ApplicationProxy Inject {}", this);
        Preconditions.checkNotNull(applicationProxyListener);
        mApplicationProxyListener = applicationProxyListener;
    }

    @Override
    public void onCreate(String processName) {
        mApplicationProxyListener.onCreate(processName);
    }

    @Override
    public void onLowMemory() {
        mApplicationProxyListener.onLowMemory();
    }

    @Override
    public void onTerminate() {
        mApplicationProxyListener.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        mApplicationProxyListener.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        mApplicationProxyListener.onConfigurationChanged(newConfig);
    }
}
