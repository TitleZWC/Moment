package com.titlezwc.moment.data.repository.datasource.appinfo;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.titlezwc.moment.data.cache.AppInfoCache;
import com.titlezwc.moment.extras.AppInfoUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by TitleZWC on 2016/12/25.
 */

public class DiskAppInfoDataStore implements AppInfoDataStore {
    private Context mContext;
    private AppInfoCache mAppInfoCache;

    @Inject
    DiskAppInfoDataStore(Context context, AppInfoCache appInfoCache) {
        mContext = context;
        mAppInfoCache = appInfoCache;
    }

    @Override
    public Observable<List<PackageInfo>> getAppInfo() {
        if (!mAppInfoCache.isCached()) {
            List<PackageInfo> list = AppInfoUtils.getAppsInfo(mContext);
            mAppInfoCache.put(list);
        }
        return mAppInfoCache.get();
    }
}
