package com.titlezwc.moment.presentation.proxy.impl;

import com.titlezwc.common.AppManager;
import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.application.proxy.listener.ApplicationActionProxyListener;
import com.titlezwc.domain.net.http.HttpError;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class ApplicationActionProxyImpl implements ApplicationActionProxyListener {
    private final BaseApplication mApplication;

    public ApplicationActionProxyImpl(BaseApplication application) {
        mApplication = application;
    }

    @Override
    public void onForeground() {

    }

    @Override
    public void onBackground() {

    }

    @Override
    public void onLauncherShow() {

    }

    @Override
    public void onExit(AppManager appManager) {
        //释放资源
        appManager.appExit(mApplication);
    }

    @Override
    public void onAppConfigCenterUpdate() {

    }

    @Override
    public void onErrorResult(HttpError httpError) {
        //弹出错误提示框等
    }
}
