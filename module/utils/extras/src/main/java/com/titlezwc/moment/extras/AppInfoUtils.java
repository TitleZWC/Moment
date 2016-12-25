package com.titlezwc.moment.extras;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Created by TitleZWC on 2016/12/25.
 */

public class AppInfoUtils {
    public static List<PackageInfo> getAppsInfo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);

        return packageInfoList;
    }
}
