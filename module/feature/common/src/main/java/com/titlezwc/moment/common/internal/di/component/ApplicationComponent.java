package com.titlezwc.moment.common.internal.di.component;

import android.content.Context;
import android.os.Handler;

import com.titlezwc.moment.common.AppManager;
import com.titlezwc.moment.common.application.BaseApplication;
import com.titlezwc.moment.common.application.proxy.ApplicationActionProxy;
import com.titlezwc.moment.common.application.proxy.ApplicationProxy;
import com.titlezwc.moment.common.internal.di.modules.ApplicationModule;
import com.titlezwc.moment.common.view.proxy.ActivityProxy;
import com.titlezwc.moment.common.view.proxy.FragmentProxy;
import com.titlezwc.moment.data.net.AppInfo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TitleZWC on 2016/12/9.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseApplication application);//注入类和使用时一致

    Context context();

    AppInfo appInfo();

    Handler handler();

    BaseApplication application();

    ApplicationActionProxy applicationActionProxy();

    ApplicationProxy applicationProxy();

    ActivityProxy activityProxy();

    FragmentProxy fragmentProxy();

    AppManager appManager();
}
