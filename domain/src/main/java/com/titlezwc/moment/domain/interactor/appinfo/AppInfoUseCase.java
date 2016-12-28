package com.titlezwc.moment.domain.interactor.appinfo;

import com.titlezwc.moment.domain.executor.PostExecutionThread;
import com.titlezwc.moment.domain.executor.ThreadExecutor;
import com.titlezwc.moment.domain.interactor.UseCase;
import com.titlezwc.moment.domain.interactor.UseCaseParams;
import com.titlezwc.moment.domain.internal.di.PerActivity;
import com.titlezwc.moment.domain.module.AppInfo;
import com.titlezwc.moment.domain.repository.AppInfoRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by TitleZWC on 2016/12/24.
 */
@PerActivity
public final class AppInfoUseCase extends UseCase {
    private final AppInfoRepository mAppInfoRepository;

    @Inject
    public AppInfoUseCase(AppInfoRepository appInfoRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mAppInfoRepository = appInfoRepository;
    }

    @Override
    protected Observable<List<AppInfo>> buildUseCaseObservable(UseCaseParams params) {
        return mAppInfoRepository.appModel();
    }
}
