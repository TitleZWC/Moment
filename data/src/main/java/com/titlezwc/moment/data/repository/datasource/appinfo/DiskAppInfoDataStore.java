package com.titlezwc.moment.data.repository.datasource.appinfo;

import android.content.pm.PackageInfo;

import com.titlezwc.moment.data.entity.AppInfoEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by TitleZWC on 2016/12/25.
 */

public class DiskAppInfoDataStore implements AppInfoDataStore{
    @Inject
    public DiskAppInfoDataStore() {
    }

    @Override
    public Observable<List<PackageInfo>> getAppInfo() {
        return Observable.empty();
    }
}
