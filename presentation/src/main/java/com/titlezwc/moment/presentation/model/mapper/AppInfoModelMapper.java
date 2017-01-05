package com.titlezwc.moment.presentation.model.mapper;

import com.titlezwc.moment.domain.module.AppInfo;
import com.titlezwc.moment.presentation.model.AppInfoModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/20.
 */

public class AppInfoModelMapper {
    @Inject
    public AppInfoModelMapper() {
    }

    public List<AppInfoModel> transform(List<AppInfo> list) {
        List<AppInfoModel> appInfoModelList = new ArrayList<>();
        for (AppInfo appInfo : list) {
            appInfoModelList.add(transform(appInfo));
        }
        return appInfoModelList;
    }

    private AppInfoModel transform(AppInfo appInfo) {
        AppInfoModel model = new AppInfoModel();
        model.setAppName(appInfo.getAppName());
        model.setDate(appInfo.getDate());
        model.setId(appInfo.getId());
        model.setOpenTimes(appInfo.getOpenTimes());
        model.setPackageName(appInfo.getPackageName());
        model.setUseTime(appInfo.getUseTime());
        model.setVersionCode(appInfo.getVersionCode());
        model.setVersionName(appInfo.getVersionName());
        return model;
    }


}
