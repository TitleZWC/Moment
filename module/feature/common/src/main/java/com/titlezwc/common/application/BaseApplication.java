package com.titlezwc.common.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.os.Handler;
import android.support.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;
import com.titlezwc.common.application.proxy.ApplicationProxy;
import com.titlezwc.common.application.proxy.listener.ApplicationActionProxyListener;
import com.titlezwc.common.application.proxy.listener.ApplicationProxyListener;
import com.titlezwc.common.assist.AppLifeCycle;
import com.titlezwc.common.assist.AppLifeCycleEvent;
import com.titlezwc.common.internal.di.HasComponent;
import com.titlezwc.common.internal.di.component.ApplicationComponent;
import com.titlezwc.common.view.proxy.listener.ActivityProxyListener;
import com.titlezwc.common.view.proxy.listener.FragmentProxyListener;
import com.titlezwc.data.net.AppInfo;
import com.titlezwc.log.LogUtils;

import javax.inject.Inject;


/**
 * Created by Administrator on 2016/11/28.
 */

public abstract class BaseApplication extends Application implements HasComponent<ApplicationComponent>, AppLifeCycleEvent {
    private ApplicationComponent mApplicationComponent;
    @Inject
    protected Handler mMainHandler;
//    @Inject
//    protected LocationManager mLocationManager;
    @Inject
    protected ApplicationProxy mApplicationProxy;
    @Inject
    protected AppLifeCycle mAppLifeCycle;

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.d("onCreate");
        initializeInjector();
        initializeDetectionComponent();
        mApplicationProxy.onCreate(getComponent().appInfo().getProcessName());
    }

    @Override
    public ApplicationComponent getComponent()

    {
        return this.mApplicationComponent;
    }


    public BaseApplication() {
        super();
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()

                .appication(this)
                .applicationProxyListener(getApplicationProxyListener())
                .activityProxyListener(getActivityProxyListener())
                .fragmentProxyListener(getFragmentProxyListener())
                .applicationActionProxyListener(getApplicationActionProxyListener())
                .appInfo(getAppInfo())
                .build();
        mApplicationComponent.inject(this);
    }


    protected abstract ApplicationProxyListener getApplicationProxyListener();
    protected abstract ActivityProxyListener getActivityProxyListener();
    protected abstract FragmentProxyListener getFragmentProxyListener();
    protected abstract ApplicationActionProxyListener getApplicationActionProxyListener();
    protected abstract AppInfo getAppInfo();


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.d("onLowMemory");
        mApplicationProxy.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        LogUtils.d("onTerminate");
        mApplicationProxy.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        LogUtils.d("onTrimMemory:{}", level);
        mApplicationProxy.onTrimMemory(level);
    }

    @Override
    public String getPackageName() {
        String packageName = super.getPackageName();
        LogUtils.d("getPackageName:{}", packageName);
        return packageName;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.d("onConfigurationChanged");
        mApplicationProxy.onConfigurationChanged(newConfig);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LogUtils.d("attachBaseContext");
        MultiDex.install(this);
    }

    protected abstract boolean debugEnable();

    private void initializeDetectionComponent() {
        if (debugEnable()) {
            LeakCanary.install(this);
        }
    }

    @Override
    public void onAppBackground() {
        mAppLifeCycle.onAppBackground();
    }

    @Override
    public void onAppForeground() {
        mAppLifeCycle.onAppForeground();
    }
}
