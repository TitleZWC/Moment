package com.titlezwc.common.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.titlezwc.common.AppManager;
import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.internal.di.HasComponent;
import com.titlezwc.common.internal.di.component.ActivityComponent;
import com.titlezwc.common.internal.di.component.ApplicationComponent;
import com.titlezwc.common.internal.di.component.DaggerApplicationComponent;
import com.titlezwc.common.internal.di.modules.ActivityModule;
import com.titlezwc.common.navigation.Navigator;
import com.titlezwc.common.view.proxy.ActivityProxy;
import com.titlezwc.log.LogUtils;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/11/28.
 */

public class BaseActivity extends FragmentActivity implements HasComponent<AppCompatActivity> {

    @Inject
    protected AppManager mAppManager;
    @Inject
    protected ActivityProxy mActivityProxy;
    @Inject
    protected Navigator mNavigator;

    private ActivityComponent mActivityComponent;

    private final String mSimpleName = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initializeInjector();
        super.onCreate(savedInstanceState);
        LogUtils.d("{}:create#1", mSimpleName);
        mActivityProxy.onCreate(this, savedInstanceState);
        mAppManager.addActivity(this);
        //将操作栏设置为悬浮
        requestWindowFeature(Window.FEATURE_ACTION_MODE_OVERLAY);
    }

    private void initializeInjector() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        mActivityComponent.inject(this);
    }

    private ApplicationComponent getApplicationComponent() {
        return ((BaseApplication) getApplication()).getComponent();
    }

    @Override
    public AppCompatActivity getComponent() {
        return null;
    }


    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
