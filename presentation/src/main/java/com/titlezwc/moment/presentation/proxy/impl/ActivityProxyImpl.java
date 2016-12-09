package com.titlezwc.moment.presentation.proxy.impl;

import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.view.proxy.listener.ActivityProxyListener;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class ActivityProxyImpl implements ActivityProxyListener {
    private final BaseApplication mApplication;
    public  ActivityProxyImpl(BaseApplication application){
        mApplication = application;
    }
}
