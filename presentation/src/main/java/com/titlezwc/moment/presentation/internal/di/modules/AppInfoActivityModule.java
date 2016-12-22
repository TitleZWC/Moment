package com.titlezwc.moment.presentation.internal.di.modules;

import com.titlezwc.moment.domain.internal.di.PerActivity;
import com.titlezwc.moment.presentation.presenter.AppInfoPresenter;
import com.titlezwc.moment.presentation.presenter.impl.AppInfoPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TitleZWC on 2016/12/20.
 */
@Module
public class AppInfoActivityModule {
    @Provides
    @PerActivity
    AppInfoPresenter provideAppInfoPresenter(AppInfoPresenterImpl appInfoPresenterImpl) {
        return appInfoPresenterImpl;
    }
}
