package com.titlezwc.moment.presentation.internal.di.components;

import com.titlezwc.moment.common.internal.di.component.ActivityComponent;
import com.titlezwc.moment.common.internal.di.component.ApplicationComponent;
import com.titlezwc.moment.common.internal.di.modules.ActivityModule;
import com.titlezwc.moment.domain.internal.di.PerActivity;
import com.titlezwc.moment.presentation.internal.di.modules.AppInfoActivityModule;
import com.titlezwc.moment.presentation.view.activity.MainActivity;

import dagger.Component;

/**
 * Created by TitleZWC on 2016/12/20.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, AppInfoActivityModule.class})
public interface AppInfoActivityComponent extends ActivityComponent {
    void inject(MainActivity activity);
}
