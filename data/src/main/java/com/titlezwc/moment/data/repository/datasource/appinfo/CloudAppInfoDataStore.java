package com.titlezwc.moment.data.repository.datasource.appinfo;

import com.titlezwc.moment.data.entity.AppInfoEntity;
import com.titlezwc.moment.data.net.Api.AppInfoApi;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by TitleZWC on 2016/12/25.
 */
public class CloudAppInfoDataStore implements AppInfoDataStore {
    private final AppInfoApi mAppInfoApi;

    @Inject
    public CloudAppInfoDataStore(AppInfoApi appInfoApi) {
        mAppInfoApi = appInfoApi;
    }

    @Override
    public Observable<AppInfoEntity> getAppInfo() {
        return Observable.empty();
    }
}
