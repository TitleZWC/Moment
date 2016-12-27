package com.titlezwc.moment.data.repository.datasource.appinfo;

import android.content.Context;

import com.titlezwc.moment.data.cache.AppInfoCache;
import com.titlezwc.moment.data.net.Api.AppInfoApi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by TitleZWC on 2016/12/24.
 */
@Singleton
public class AppInfoDataStoreFactory {
    private final AppInfoApi mAppInfoApi;
    private Context mContext;
    private AppInfoCache mAppInfoCache;

    @Inject
    public AppInfoDataStoreFactory(Context context, AppInfoApi appInfoApi, AppInfoCache appInfoCache) {
        mAppInfoApi = appInfoApi;
        mContext = context;
        mAppInfoCache = appInfoCache;
    }

    public CloudAppInfoDataStore createAppInfoCloud() {
        return new CloudAppInfoDataStore(mAppInfoApi);
    }

    public DiskAppInfoDataStore createAppInfoDisk() {
        return new DiskAppInfoDataStore(mContext, mAppInfoCache);
    }
}
