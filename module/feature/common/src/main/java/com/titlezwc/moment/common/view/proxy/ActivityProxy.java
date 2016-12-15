package com.titlezwc.moment.common.view.proxy;

import android.content.Intent;
import android.os.Bundle;

import com.titlezwc.moment.common.view.activity.BaseActivity;
import com.titlezwc.moment.common.view.proxy.listener.ActivityProxyListener;
import com.titlezwc.moment.log.LogUtils;

import javax.inject.Inject;

import dagger.internal.Preconditions;

/**
 * Created by TitleZWC on 2016/12/8.
 */

public class ActivityProxy implements ActivityProxyListener {
    private final ActivityProxyListener mListener;

    @Inject
    public ActivityProxy(ActivityProxyListener listener) {
        LogUtils.d("ActivityProxy Inject {}", this);
        Preconditions.checkNotNull(listener);
        mListener = listener;
    }

    @Override
    public void onCreate(BaseActivity activity, Bundle saveInstanceState) {
        LogUtils.d("onCreate");
        mListener.onCreate(activity, saveInstanceState);
    }

    @Override
    public void onStart(BaseActivity activity) {
        LogUtils.d("onStart");
        mListener.onStart(activity);
    }

    @Override
    public void onRestart(BaseActivity activity) {
        LogUtils.d("onRestart");
        mListener.onRestart(activity);
    }

    @Override
    public void onStop(BaseActivity activity) {
        LogUtils.d("onStop");
        mListener.onStop(activity);
    }

    @Override
    public void onResume(BaseActivity activity) {
        LogUtils.d("onResume");
        mListener.onResume(activity);
    }

    @Override
    public void onPause(BaseActivity activity) {
        LogUtils.d("onPause");
        mListener.onPause(activity);
    }

    @Override
    public void onDestroy(BaseActivity activity) {
        LogUtils.d("onDestroy");
        mListener.onDestroy(activity);
    }

    @Override
    public void onLowMemory(BaseActivity activity) {
        LogUtils.d("onLowMemory");
        mListener.onLowMemory(activity);
    }

    @Override
    public void startActivity(BaseActivity activity, Intent intent) {
        LogUtils.d("startActivity");
        mListener.startActivity(activity, intent);
    }

    @Override
    public void startActivityForResult(BaseActivity activity, Intent intent, int requestCode, Bundle options) {
        mListener.startActivityForResult(activity, intent, requestCode, options);
        LogUtils.d("startActivityForResult");
    }
}
