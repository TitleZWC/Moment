package com.titlezwc.moment.data.repository.datasource.appinfo;

import android.content.pm.PackageInfo;


import java.util.List;

import rx.Observable;


/**
 * Created by TitleZWC on 2016/12/25.
 */

public interface AppInfoDataStore {
    Observable<List<PackageInfo>> getAppInfo();
}
