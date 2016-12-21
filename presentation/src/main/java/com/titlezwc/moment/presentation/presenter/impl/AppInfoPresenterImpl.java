package com.titlezwc.moment.presentation.presenter.impl;

import com.titlezwc.moment.presentation.presenter.AppInfoPresenter;
import com.titlezwc.moment.presentation.utils.AppInfoUtils;
import com.titlezwc.moment.presentation.view.AppInfoView;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/20.
 */

public class AppInfoPresenterImpl implements AppInfoPresenter {
    private AppInfoView mView;

    @Override
    public void setView(AppInfoView view) {
        mView = view;
    }

    @Override
    public void getAppsList() {
        mView.onAppsListGot(AppInfoUtils.getAppsInfo(mView.getContext()));
    }

    @Inject
    public AppInfoPresenterImpl() {

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

    }


}
