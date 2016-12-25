package com.titlezwc.moment.data.repository.datasource.appinfo;

import com.titlezwc.moment.data.net.Api.AppInfoApi;
import com.titlezwc.moment.domain.internal.di.PerActivity;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/24.
 */
@PerActivity
public class AppInfoDataStoreFactory {
    private final AppInfoApi mAppInfoApi;

    @Inject
    public AppInfoDataStoreFactory(AppInfoApi appInfoApi) {
        mAppInfoApi = appInfoApi;
    }

    public CloudAppInfoDataStore createAppInfoCloud() {
        return new CloudAppInfoDataStore(mAppInfoApi);
    }

    public DiskAppInfoDataStore createAppInfoDisk() {
        return new DiskAppInfoDataStore();
    }
}
