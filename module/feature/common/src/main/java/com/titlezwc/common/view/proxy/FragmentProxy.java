package com.titlezwc.common.view.proxy;

import com.titlezwc.common.view.fragment.BaseFragment;
import com.titlezwc.common.view.proxy.listener.FragmentProxyListener;
import com.titlezwc.log.LogUtils;

import javax.inject.Inject;

import dagger.internal.Preconditions;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class FragmentProxy implements FragmentProxyListener {
    private final FragmentProxyListener mListener;

    @Inject
    public FragmentProxy(FragmentProxyListener listener) {
        LogUtils.d("FragmentProxy Inject {}", this);
        Preconditions.checkNotNull(listener);
        mListener = listener;
    }

    @Override
    public void onCreate(BaseFragment fragment) {
        LogUtils.d("onCreate");
        mListener.onCreate(fragment);
    }

    @Override
    public void onCreateView(BaseFragment fragment) {
        LogUtils.d("onCreateView");
        mListener.onCreateView(fragment);
    }

    @Override
    public void onActivityCreated(BaseFragment fragment) {
        LogUtils.d("onActivityCreated");
        mListener.onActivityCreated(fragment);
    }

    @Override
    public void onViewCreated(BaseFragment fragment) {
        LogUtils.d("onViewCreated");
        mListener.onViewCreated(fragment);
    }

    @Override
    public void onAttach(BaseFragment fragment) {
        LogUtils.d("onAttach");
        mListener.onAttach(fragment);
    }

    @Override
    public void onDestroy(BaseFragment fragment) {
        LogUtils.d("onCreate");
        mListener.onCreate(fragment);
    }

    @Override
    public void onResume(BaseFragment fragment) {
        LogUtils.d("onResume");
        mListener.onResume(fragment);
    }

    @Override
    public void onPause(BaseFragment fragment) {
        LogUtils.d("onPause");
        mListener.onPause(fragment);
    }

    @Override
    public void onStart(BaseFragment fragment) {
        LogUtils.d("onStart");
        mListener.onStart(fragment);
    }

    @Override
    public void onStop(BaseFragment fragment) {
        LogUtils.d("onStop");
        mListener.onStop(fragment);
    }

    @Override
    public void onDestroyView(BaseFragment fragment) {
        LogUtils.d("onDestroyView");
        mListener.onDestroyView(fragment);
    }
}