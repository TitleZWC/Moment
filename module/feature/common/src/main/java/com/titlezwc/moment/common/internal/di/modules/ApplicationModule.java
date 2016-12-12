package com.titlezwc.common.internal.di.modules;


import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.application.proxy.listener.ApplicationActionProxyListener;
import com.titlezwc.common.application.proxy.listener.ApplicationProxyListener;
import com.titlezwc.common.view.proxy.listener.ActivityProxyListener;
import com.titlezwc.common.view.proxy.listener.DefaultActivityProxyListener;
import com.titlezwc.common.view.proxy.listener.DefaultFragmentProxyListener;
import com.titlezwc.common.view.proxy.listener.FragmentProxyListener;
import com.titlezwc.data.net.AppInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TitleZWC on 2016/12/9.
 */

@Module
public class ApplicationModule {
    private final BaseApplication mApplication;
    private final Handler mHandler;
    private final ApplicationProxyListener mApplicationProxyListener;
    private final ActivityProxyListener mActivityProxyListener;
    private final FragmentProxyListener mFragmentProxyListener;
    private final ApplicationActionProxyListener mApplicationActionProxyListener;
    private final AppInfo mAppInfo;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private ApplicationModule(Builder builder) {
        this.mApplication = builder.application;
        mHandler = new Handler();
        this.mApplicationProxyListener = builder.applicationProxyListener;
        this.mActivityProxyListener = builder.activityProxyListener;
        this.mFragmentProxyListener = builder.fragmentProxyListener;
        this.mApplicationActionProxyListener = builder.applicationActionProxyListener;
        this.mAppInfo = builder.appInfo;
    }

    @Provides
    @Singleton
    Context providedContext() {
        return this.mApplication;
    }

    @Provides
    @Singleton
    BaseApplication providedApplication() {
        return this.mApplication;
    }

    @Provides
    @Singleton
    ActivityProxyListener providedActivityProxyListener() {
        return mActivityProxyListener;
    }

    @Provides
    @Singleton
    ApplicationProxyListener providedApplicationProxyListener() {
        return mApplicationProxyListener;
    }

    @Provides
    @Singleton
    FragmentProxyListener providedFragmentProxyListener() {
        return mFragmentProxyListener;
    }

    @Provides
    @Singleton
    ApplicationActionProxyListener providedApplicationActionProxyListener() {
        return mApplicationActionProxyListener;
    }

    @Provides
    @Singleton
    AppInfo providedAppInfo() {
        return mAppInfo;
    }

    @Provides
    @Singleton
    Handler providedHandler() {
        return mHandler;
    }

    public static class Builder {
        private BaseApplication application;
        private ApplicationProxyListener applicationProxyListener;
        private ActivityProxyListener activityProxyListener;
        private FragmentProxyListener fragmentProxyListener;
        private ApplicationActionProxyListener applicationActionProxyListener;
        private AppInfo appInfo;

        public Builder() {

        }

        public Builder application(@NonNull BaseApplication application) {
            this.application = application;
            return this;
        }

        public Builder applicationProxyListener(ApplicationProxyListener applicationProxyListener) {
            this.applicationProxyListener = applicationProxyListener;
            return this;
        }

        public Builder activityProxyListener(ActivityProxyListener activityProxyListener) {
            this.activityProxyListener = activityProxyListener;
            return this;
        }

        public Builder fragmentProxyListener(FragmentProxyListener fragmentProxyListener) {
            this.fragmentProxyListener = fragmentProxyListener;
            return this;
        }

        public Builder applicationActionProxyListener(ApplicationActionProxyListener applicationActionProxyListener) {
            this.applicationActionProxyListener = applicationActionProxyListener;
            return this;
        }

        public Builder appInfo(AppInfo appInfo) {
            this.appInfo = appInfo;
            return this;
        }

        private void initEmptyFirldsWithDefaultValue() {
            if (null == this.activityProxyListener) {
                this.activityProxyListener = new DefaultActivityProxyListener();
            }
            if (null == this.fragmentProxyListener) {
                this.fragmentProxyListener = new DefaultFragmentProxyListener();
            }
        }

        public ApplicationModule build() {
            initEmptyFirldsWithDefaultValue();
            return new ApplicationModule(this);
        }

    }
}
