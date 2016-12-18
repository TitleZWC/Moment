package com.titlezwc.moment.presentation.view;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TitleZWC on 2016/12/19.
 */

public class InfoService extends Service {
    private List<AppInfo> appInfoList;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void getAppInfo() {
        appInfoList = new ArrayList<>();
        List<PackageInfo> packageInfos = getPackageManager().getInstalledPackages(0);
        for (PackageInfo info : packageInfos) {
            AppInfo tmpInfo = new AppInfo();
            tmpInfo.setAppName(info.applicationInfo.loadLabel(getPackageManager()).toString());
            tmpInfo.setPackageName(info.packageName);
            tmpInfo.setVersionName(info.versionName);
            tmpInfo.setVersionCode(info.versionCode);
            tmpInfo.setIcon(info.applicationInfo.loadIcon(getPackageManager()));
            appInfoList.add(tmpInfo);
        }
    }
}
