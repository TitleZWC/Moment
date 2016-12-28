package com.titlezwc.moment.presentation.internal.di.modules;

import com.titlezwc.moment.data.repository.AppInfoDataRepository;
import com.titlezwc.moment.domain.executor.PostExecutionThread;
import com.titlezwc.moment.domain.executor.ThreadExecutor;
import com.titlezwc.moment.domain.interactor.UseCase;
import com.titlezwc.moment.domain.interactor.appinfo.AppInfoUseCase;
import com.titlezwc.moment.domain.internal.di.PerActivity;
import com.titlezwc.moment.domain.repository.AppInfoRepository;
import com.titlezwc.moment.presentation.constant.InterfaceName;
import com.titlezwc.moment.presentation.presenter.AppInfoPresenter;
import com.titlezwc.moment.presentation.presenter.impl.AppInfoPresenterImpl;

import javax.inject.Named;

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

    @Provides
    @PerActivity
    AppInfoRepository provideAppInfoRepository(AppInfoDataRepository appInfoDataRepository) {
        return appInfoDataRepository;
    }

    @Provides
    @PerActivity
    @Named(InterfaceName.NAMED_APP_INFO)
    UseCase provideAppInfoUseCase(AppInfoRepository appInfoRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new AppInfoUseCase(appInfoRepository, threadExecutor, postExecutionThread);
    }

}
