package com.titlezwc.moment.common.internal.di.component;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.titlezwc.moment.common.AppManager;
import com.titlezwc.moment.common.application.proxy.ApplicationActionProxy;
import com.titlezwc.moment.common.application.proxy.ApplicationProxy;
import com.titlezwc.moment.common.internal.di.modules.ActivityModule;
import com.titlezwc.moment.common.view.activity.BaseActivity;
import com.titlezwc.moment.common.view.proxy.ActivityProxy;
import com.titlezwc.moment.common.view.proxy.FragmentProxy;
import com.titlezwc.moment.domain.internal.di.PerActivity;

import dagger.Component;

/**
 * Created by TitleZWC on 2016/12/12.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity activity);

    Activity activity();

    Context context();

    AppManager appManager();

    ApplicationProxy applicationProxy();

    ActivityProxy activityProxy();

    FragmentProxy fragmentProxy();

    ApplicationActionProxy applicationActionProxy();

    Handler handler();
}
