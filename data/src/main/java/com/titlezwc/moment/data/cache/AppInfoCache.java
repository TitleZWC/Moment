package com.titlezwc.moment.data.cache;

import android.content.pm.PackageInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by TitleZWC on 2016/12/23.
 */

public interface AppInfoCache {
    Observable<List<PackageInfo>> get();

    void put(List<PackageInfo> list);

    boolean isCached();

    boolean isExpired();

    void evictAll();
}
