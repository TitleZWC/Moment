package com.titlezwc.moment.presentation.proxy.impl;

import android.content.Intent;
import android.os.Bundle;

import com.titlezwc.moment.common.application.BaseApplication;
import com.titlezwc.moment.common.view.activity.BaseActivity;
import com.titlezwc.moment.common.view.proxy.listener.ActivityProxyListener;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public class ActivityProxyImpl implements ActivityProxyListener {
    private final BaseApplication mApplication;

    public ActivityProxyImpl(BaseApplication application) {
        mApplication = application;
    }

    @Override
    public void onCreate(BaseActivity activity, Bundle saveInstanceState) {

    }

    @Override
    public void onStart(BaseActivity activity) {

    }

    @Override
    public void onRestart(BaseActivity activity) {

    }

    @Override
    public void onStop(BaseActivity activity) {

    }

    @Override
    public void onResume(BaseActivity activity) {
        MobclickAgent.onResume(activity);
    }

    @Override
    public void onPause(BaseActivity activity) {
        MobclickAgent.onPause(activity);
    }

    @Override
    public void onDestroy(BaseActivity activity) {

    }

    @Override
    public void onLowMemory(BaseActivity activity) {

    }

    @Override
    public void startActivity(BaseActivity activity, Intent intent) {

    }

    @Override
    public void startActivityForResult(BaseActivity activity, Intent intent, int requestCode, Bundle options) {

    }
}
