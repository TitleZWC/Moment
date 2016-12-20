package com.titlezwc.moment.presentation.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.titlezwc.moment.presentation.model.AppInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TitleZWC on 2016/12/21.
 */

public class AppInfoUtils {
    public static List<AppInfoModel> getAppsInfo(Context context) {
        List appInfoModelList = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        for (PackageInfo info : packageInfos) {
            AppInfoModel tmpInfo = new AppInfoModel();
            tmpInfo.setAppName(info.applicationInfo.loadLabel(packageManager).toString());
            tmpInfo.setPackageName(info.packageName);
            tmpInfo.setVersionName(info.versionName);
            tmpInfo.setVersionCode(info.versionCode);
            tmpInfo.setIcon(info.applicationInfo.loadIcon(packageManager));
            appInfoModelList.add(tmpInfo);
        }
        return appInfoModelList;
    }
}
