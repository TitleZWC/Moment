package com.titlezwc.moment.data.entity.mapper;

import com.titlezwc.moment.data.entity.AppInfoEntity;
import com.titlezwc.moment.domain.module.AppInfo;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/25.
 */

public class AppInfoEntityDataMapper {
    @Inject
    public AppInfoEntityDataMapper() {
    }

    public AppInfo transform(AppInfoEntity entity) {
        AppInfo appInfo = new AppInfo();
        appInfo.setAppName(entity.getAppName());
//        appInfo.setIcon(entity.getIcon());
        return appInfo;
    }

}
