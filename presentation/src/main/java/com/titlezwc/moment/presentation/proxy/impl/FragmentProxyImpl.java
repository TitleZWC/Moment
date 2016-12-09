package com.titlezwc.moment.presentation.proxy.impl;

import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.view.proxy.listener.FragmentProxyListener;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class FragmentProxyImpl implements FragmentProxyListener {
    private final BaseApplication mApplication;
    public  FragmentProxyImpl(BaseApplication application){
        mApplication = application;
    }

}
