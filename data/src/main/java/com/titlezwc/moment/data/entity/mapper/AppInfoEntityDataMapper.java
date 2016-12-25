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
            PackageManager packageManager = mContext.getPackageManager();
            for (PackageInfo info : list) {
                AppInfo appInfo = new AppInfo();
                appInfo.setAppName(info.applicationInfo.loadLabel(packageManager).toString());
                appInfo.setPackageName(info.packageName);
                appInfo.setVersionName(info.versionName);
                appInfo.setVersionCode(info.versionCode);
//                appInfo.setIcon(info.applicationInfo.loadIcon(packageManager));
                appInfoModelList.add(appInfo);
            }
        }
        return appInfoModelList;
    }

}
