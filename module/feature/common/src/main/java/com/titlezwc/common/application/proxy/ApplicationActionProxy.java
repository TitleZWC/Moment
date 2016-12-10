package com.titlezwc.common.application.proxy;

import com.titlezwc.common.AppManager;
import com.titlezwc.common.application.proxy.listener.ApplicationActionProxyListener;
import com.titlezwc.common.view.proxy.listener.ActivityProxyListener;
import com.titlezwc.domain.net.http.HttpError;
import com.titlezwc.log.LogUtils;

import javax.inject.Inject;

import dagger.internal.Preconditions;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class ApplicationActionProxy implements ApplicationActionProxyListener {
    private final ApplicationActionProxyListener mListener;

    @Inject
    public ApplicationActionProxy(ApplicationActionProxyListener listener) {
        LogUtils.d("ApplicationActionProxy Inject {}", this);
        Preconditions.checkNotNull(listener);
        mListener = listener;
    }

    @Override
    public void onForeground() {
        LogUtils.d("onForeground");
        mListener.onForeground();
    }

    @Override
    public void onBackground() {
        LogUtils.d("onBackground");
        mListener.onBackground();
    }

    @Override
    public void onLauncherShow() {
        LogUtils.d("onLauncherShow");
        mListener.onLauncherShow();
    }

    @Override
    public void onExit(AppManager appManager) {
        LogUtils.d("onExit");
        mListener.onExit(appManager);
    }

    @Override
    public void onAppConfigCenterUpdate() {
        LogUtils.d("onAppConfigCenterUpdate");
        mListener.onAppConfigCenterUpdate();
    }

    @Override
    public void onErrorResult(HttpError httpError) {
        LogUtils.d("onBackground");
        mListener.onErrorResult(httpError);
    }
}