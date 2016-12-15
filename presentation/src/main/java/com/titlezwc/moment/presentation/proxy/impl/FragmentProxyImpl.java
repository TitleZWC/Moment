package com.titlezwc.moment.presentation.proxy.impl;

import com.titlezwc.moment.common.application.BaseApplication;
import com.titlezwc.moment.common.view.fragment.BaseFragment;
import com.titlezwc.moment.common.view.proxy.listener.FragmentProxyListener;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class FragmentProxyImpl implements FragmentProxyListener {
    private final BaseApplication mApplication;
    public  FragmentProxyImpl(BaseApplication application){
        mApplication = application;
    }

    @Override
    public void onCreate(BaseFragment fragment) {

    }

    @Override
    public void onCreateView(BaseFragment fragment) {

    }

    @Override
    public void onActivityCreated(BaseFragment fragment) {

    }

    @Override
    public void onViewCreated(BaseFragment fragment) {

    }

    @Override
    public void onAttach(BaseFragment fragment) {

    }

    @Override
    public void onDestroy(BaseFragment fragment) {

    }

    @Override
    public void onResume(BaseFragment fragment) {

    }

    @Override
    public void onPause(BaseFragment fragment) {

    }

    @Override
    public void onStart(BaseFragment fragment) {

    }

    @Override
    public void onStop(BaseFragment fragment) {

    }

    @Override
    public void onDestroyView(BaseFragment fragment) {

    }
}
