package com.titlezwc.moment.data.repository;

import com.titlezwc.moment.data.entity.mapper.AppInfoEntityDataMapper;
import com.titlezwc.moment.domain.module.AppInfo;
import com.titlezwc.moment.data.repository.datasource.appinfo.AppInfoDataStoreFactory;
import com.titlezwc.moment.domain.repository.AppInfoRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by TitleZWC on 2016/12/23.
 */

public class AppInfoDataRepository implements AppInfoRepository {
    private final AppInfoDataStoreFactory mAppInfoDataStoreFactory;
    private final AppInfoEntityDataMapper mAppInfoEntityDataMapper;

    @Inject
    public AppInfoDataRepository(AppInfoDataStoreFactory appInfoDataStoreFactory, AppInfoEntityDataMapper appInfoEntityDataMapper) {
        mAppInfoDataStoreFactory = appInfoDataStoreFactory;
        mAppInfoEntityDataMapper = appInfoEntityDataMapper;
    }

    @Override
    public Observable<AppInfo> appModel() {
        return this.mAppInfoDataStoreFactory.createAppInfoCloud().getAppInfo().map(mAppInfoEntityDataMapper::transform);
    }
}
