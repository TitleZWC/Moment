package com.titlezwc.moment.presentation.service;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.titlezwc.moment.presentation.model.AppInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TitleZWC on 2016/12/19.
 */

public class InfoService extends Service {
    private List<AppInfoModel> appInfoModelList;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void getAppInfo() {
        appInfoModelList = new ArrayList<>();
        List<PackageInfo> packageInfos = getPackageManager().getInstalledPackages(0);
        for (PackageInfo info : packageInfos) {
            AppInfoModel tmpInfo = new AppInfoModel();
            tmpInfo.setAppName(info.applicationInfo.loadLabel(getPackageManager()).toString());
            tmpInfo.setPackageName(info.packageName);
            tmpInfo.setVersionName(info.versionName);
            tmpInfo.setVersionCode(info.versionCode);
            tmpInfo.setIcon(info.applicationInfo.loadIcon(getPackageManager()));
            appInfoModelList.add(tmpInfo);
        }
    }
}
