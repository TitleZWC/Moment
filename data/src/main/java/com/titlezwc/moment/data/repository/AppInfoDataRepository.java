package com.titlezwc.moment.data.repository;

import android.content.pm.PackageInfo;

import com.titlezwc.moment.data.entity.mapper.AppInfoEntityDataMapper;
import com.titlezwc.moment.domain.internal.di.PerActivity;
import com.titlezwc.moment.domain.module.AppInfo;
import com.titlezwc.moment.data.repository.datasource.appinfo.AppInfoDataStoreFactory;
import com.titlezwc.moment.domain.repository.AppInfoRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by TitleZWC on 2016/12/23.
 */
@PerActivity
public class AppInfoDataRepository implements AppInfoRepository {
    private final AppInfoDataStoreFactory mAppInfoDataStoreFactory;
    private final AppInfoEntityDataMapper mAppInfoEntityDataMapper;

    @Inject
    public AppInfoDataRepository(AppInfoDataStoreFactory appInfoDataStoreFactory, AppInfoEntityDataMapper appInfoEntityDataMapper) {
        mAppInfoDataStoreFactory = appInfoDataStoreFactory;
        mAppInfoEntityDataMapper = appInfoEntityDataMapper;
    }

    @Override
    public Observable<List<AppInfo>> appModel() {
        return this.mAppInfoDataStoreFactory.createAppInfoCloud().getAppInfo().map(mAppInfoEntityDataMapper::transform);
//        return this.mAppInfoDataStoreFactory.createAppInfoCloud().getAppInfo().map(new Func1<List<PackageInfo>, List<AppInfo>>() {
//            @Override
//            public List<AppInfo> call(List<PackageInfo> packageInfo) {
//                return mAppInfoEntityDataMapper.transform(packageInfo);
//            }
//        });
    }
}
