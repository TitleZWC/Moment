package com.titlezwc.moment.data.repository.datasource.appinfo;

import android.content.pm.PackageInfo;

import com.titlezwc.moment.data.entity.AppInfoEntity;
import com.titlezwc.moment.data.net.Api.AppInfoApi;

import java.util.List;

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
    public Observable<List<PackageInfo>> getAppInfo() {
        return Observable.empty();
    }
}
