package com.titlezwc.common.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.os.Handler;
import android.support.multidex.MultiDex;

import com.titlezwc.common.application.proxy.ApplicationProxy;
import com.titlezwc.common.assist.AppLifeCycle;
import com.titlezwc.common.assist.AppLifeCycleEvent;
import com.titlezwc.log.LogUtils;

import javax.inject.Inject;


/**
 * Created by Administrator on 2016/11/28.
 */

public abstract class BaseApplication extends Application implements  AppLifeCycleEvent{//HasComponent<ApplicationComponent>, AppLifeCycleEvent {
//    private ApplicationComponent mApplicationComponenr;
    @Inject
    protected Handler mMainHandler;
    @Inject
    protected LocationManager mLocationManager;
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
//        mApplicationProxy.onCreate(getComonpent().appInfo().getProcessName());
    }


    private void initializeInjector() {

    }

//    public ApplicationComponent getComponent() {
//        return mApplicationComponenr;
//    }

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
//        if(debugEnable()){
//            AppBlockCanary.start(this,debugEnable());
//            LeakCanary.install(this)
//        }
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
