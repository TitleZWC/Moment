package com.titlezwc.moment.data.repository.datasource.appinfo;

import com.titlezwc.moment.data.entity.AppInfoEntity;

import rx.Observable;


/**
 * Created by TitleZWC on 2016/12/25.
 */

public interface AppInfoDataStore {
    Observable<AppInfoEntity> getAppInfo();
}
