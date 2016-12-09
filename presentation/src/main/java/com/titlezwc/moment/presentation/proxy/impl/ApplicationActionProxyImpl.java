package com.titlezwc.moment.presentation.proxy.impl;

import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.application.proxy.listener.ApplicationActionProxyListener;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class ApplicationActionProxyImpl implements ApplicationActionProxyListener {
    private final BaseApplication mApplication;

    public ApplicationActionProxyImpl(BaseApplication application) {
        mApplication = application;
    }
}
