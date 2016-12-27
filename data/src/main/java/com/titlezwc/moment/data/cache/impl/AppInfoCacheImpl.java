package com.titlezwc.moment.data.cache.impl;

import android.content.pm.PackageInfo;

import com.titlezwc.moment.data.cache.AppInfoCache;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by TitleZWC on 2016/12/24.
 */
@Singleton
public class AppInfoCacheImpl implements AppInfoCache {
    private List<PackageInfo> mList;

    @Inject
    public AppInfoCacheImpl() {
    }

    @Override
    public Observable<List<PackageInfo>> get() {
        return Observable.just(mList);
    }

    @Override
    public void put(List<PackageInfo> list) {
        mList = list;
    }

    @Override
    public boolean isCached() {
        return null != mList && !mList.isEmpty();
    }

    @Override
    public boolean isExpired() {
        return isCached();
    }

    @Override
    public void evictAll() {
        mList = null;
    }
}
