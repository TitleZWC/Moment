package com.titlezwc.moment.common.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import com.titlezwc.moment.common.AppManager;
import com.titlezwc.moment.common.application.BaseApplication;
import com.titlezwc.moment.common.internal.di.HasComponent;
import com.titlezwc.moment.common.internal.di.component.ActivityComponent;
import com.titlezwc.moment.common.internal.di.component.ApplicationComponent;
import com.titlezwc.moment.common.internal.di.component.DaggerActivityComponent;
import com.titlezwc.moment.common.internal.di.modules.ActivityModule;
import com.titlezwc.moment.common.navigation.Navigator;
import com.titlezwc.moment.common.view.proxy.ActivityProxy;
import com.titlezwc.moment.log.LogUtils;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/11/28.
 */

public class BaseActivity extends FragmentActivity implements HasComponent<ActivityComponent> {

    @Inject
    protected AppManager mAppManager;
    @Inject
    protected ActivityProxy mActivityProxy;
    @Inject
    protected Navigator mNavigator;

    private ActivityComponent mActivityComponent;

    private final String mSimpleName = getClass().getSimpleName();

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

    protected void initializeInjector() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        mActivityComponent.inject(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mActivityProxy.onRestart(this);
        LogUtils.d("{}:onRestart", mSimpleName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityProxy.onStart(this);
        LogUtils.d("{}:onStart", mSimpleName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityProxy.onResume(this);
        LogUtils.d("{}:onResume", mSimpleName);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActivityProxy.onPause(this);
        LogUtils.d("{}:onPause", mSimpleName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mActivityProxy.onStop(this);
        LogUtils.d("{}:onStop", mSimpleName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityProxy.onDestroy(this);
        mAppManager.removeActivity(this);
        LogUtils.d("{}:onDestroy", mSimpleName);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        LogUtils.d("{}:onCreate#2", mSimpleName);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.d("{}:onDetachedFromWindow", mSimpleName);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.d("{}:onActivityResult requestCode={}, resultCode={}, data={}", mSimpleName, requestCode, resultCode, data);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d("{}:onNewIntent", mSimpleName);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        LogUtils.d("{}:onResumeFragments", mSimpleName);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mActivityProxy.onLowMemory(this);
        LogUtils.d("{}:onLowMemory", mSimpleName);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.d("{}:onSaveInstanceState", mSimpleName);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtils.d("{}:onSaveInstanceState#2", mSimpleName);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.d("{}:onRestoreInstanceState", mSimpleName);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        LogUtils.d("{}:onRestoreInstanceState#2", mSimpleName);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        mActivityProxy.startActivity(this, intent);
        LogUtils.d("{}:startActivity", mSimpleName);
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
        mActivityProxy.startActivity(this, intent);
        LogUtils.d("{}:startActivity#2", mSimpleName);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        mActivityProxy.startActivityForResult(this, intent, requestCode, options);
        LogUtils.d("{}:startActivityForResult", mSimpleName);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseApplication) getApplication()).getComponent();
    }

    @Override
    public ActivityComponent getComponent() {
        return mActivityComponent;
    }


    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
