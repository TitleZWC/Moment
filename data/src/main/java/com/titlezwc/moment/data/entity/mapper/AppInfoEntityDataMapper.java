package com.titlezwc.moment.data.entity.mapper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.titlezwc.moment.data.entity.AppInfoEntity;
import com.titlezwc.moment.domain.module.AppInfo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/25.
 */

public class AppInfoEntityDataMapper {
    private Context mContext;
    @Inject
    public AppInfoEntityDataMapper(Context context) {
        mContext = context;
    }

    public List<AppInfo> transform(List<PackageInfo> list) {
        List<AppInfo> appInfoModelList = new ArrayList<>();
        if(null!=list&&!list.isEmpty()){

            for (PackageInfo info : list) {
//                AppInfo appInfo = new AppInfo();AppInfo
//                appInfo.setAppName(info.applicationInfo.loadLabel(packageManager).toString());
//                appInfo.setPackageName(info.packageName);
//                appInfo.setVersionName(info.versionName);
//                appInfo.setVersionCode(info.versionCode);
//                appInfo.setIcon(info.applicationInfo.loadIcon(packageManager));
                appInfoModelList.add(transform(info));
            }
        }
        return appInfoModelList;
    }
    private AppInfo transform(PackageInfo entity){
        PackageManager packageManager = mContext.getPackageManager();
        AppInfo appInfo = new AppInfo();
        appInfo.setAppName(entity.applicationInfo.loadLabel(packageManager).toString());
        appInfo.setPackageName(entity.packageName);
        appInfo.setVersionName(entity.versionName);
        appInfo.setVersionCode(entity.versionCode);

//        appInfo.setAppName(entity.applicationInfo.loadLabel(packageManager).toString());
//        appInfo.setDate(entity.getDate());
//        appInfo.setId(entity.getId());
//        appInfo.setOpenTimes(entity.getOpenTimes());
//        appInfo.setPackageName(entity.getPackageName());
//        appInfo.setUseTime(entity.getUseTime());
//        appInfo.setVersionCode(entity.getVersionCode());
//        appInfo.setVersionName(entity.getVersionName());
        return appInfo;
    }


}
