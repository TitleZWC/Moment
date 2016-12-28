package com.titlezwc.moment.presentation.presenter.impl;

import com.titlezwc.moment.domain.interactor.DefaultSubscriber;
import com.titlezwc.moment.domain.interactor.UseCase;
import com.titlezwc.moment.domain.module.AppInfo;
import com.titlezwc.moment.presentation.constant.InterfaceName;
import com.titlezwc.moment.presentation.model.mapper.AppInfoModelMapper;
import com.titlezwc.moment.presentation.presenter.AppInfoPresenter;
import com.titlezwc.moment.presentation.view.AppInfoView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by TitleZWC on 2016/12/20.
 */

public class AppInfoPresenterImpl implements AppInfoPresenter {
    private AppInfoView mView;
    private final UseCase mAppInfoUseCase;
    private final AppInfoModelMapper mAppInfoModelMapper;

    @Inject
    protected AppInfoPresenterImpl(@Named(InterfaceName.NAMED_APP_INFO) UseCase appInfoUseCase, AppInfoModelMapper appInfoModelMapper) {
        mAppInfoUseCase = appInfoUseCase;
        mAppInfoModelMapper = appInfoModelMapper;
    }

    @Override
    public void setView(AppInfoView view) {
        mView = view;
    }

    @Override
    public void getAppsList() {
//        mView.onAppsListGot(AppInfoUtils.getAppsInfo(mView.getContext()));
        mAppInfoUseCase.execute(new DefaultSubscriber<List<AppInfo>>() {
            @Override
            public void onNext(List<AppInfo> list) {
                super.onNext(list);
                mView.onAppsListGot(mAppInfoModelMapper.transform(list));
            }
        });
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        mAppInfoUseCase.unsubscribe();
    }


}
