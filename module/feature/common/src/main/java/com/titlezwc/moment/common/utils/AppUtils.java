package com.titlezwc.moment.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.telecom.TelecomManager;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by TitleZWC on 2016/12/10.
 */

public class AppUtils {
    public static String getProcessName(Context context) {
        final int pid = android.os.Process.myPid();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> listTaskInfo = am.getRunningAppProcesses();
        if (null != listTaskInfo && !listTaskInfo.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo info : listTaskInfo) {
                if (null != info && info.pid == pid) {
                    return info.processName;
                }
            }
        }
        return null;
    }

    public static int getProcessIdByName(Context context, String name) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> listTaskInfo = am.getRunningAppProcesses();
        if (null != listTaskInfo && !listTaskInfo.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo info : listTaskInfo) {
                if (null != info && info.processName.equals(name)) {
                    return info.pid;
                }
            }
        }
        return 0;
    }

    private static final int KEY_SYSTEM_ROOT_STATUS_UNKNOW = -1;
    private static final int KEY_SYSTEM_ROOT_STATUS_DISABLE = 0;
    private static final int KEY_SYSTEM_ROOT_STATUS_ENABLE = 1;
    private static int systemRootStatus = KEY_SYSTEM_ROOT_STATUS_UNKNOW;

    public static boolean isRootSystem() {
        if (systemRootStatus == KEY_SYSTEM_ROOT_STATUS_DISABLE) {
            return false;
        } else if (systemRootStatus == KEY_SYSTEM_ROOT_STATUS_ENABLE) {
            return true;
        }
        File f = null;
        final String kSuSearchPaths[] = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        try {
            for (String str : kSuSearchPaths) {
                f = new File(str.concat("su"));
                if (null != f && f.exists()) {
                    systemRootStatus = KEY_SYSTEM_ROOT_STATUS_ENABLE;
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        systemRootStatus = KEY_SYSTEM_ROOT_STATUS_DISABLE;
        return false;
    }

    public static final String getLanguage(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        Locale locale = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = configuration.getLocales().get(0);
        } else {
            locale = configuration.locale;
        }
        return locale.getLanguage().toLowerCase().concat("_").concat(locale.getCountry().toUpperCase());
    }
//    public static String getUuid(Context context){
//        @SuppressLint("ServiceCast")
//        final TelecomManager tm = (TelecomManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        final String tmDevice,tmSerial,androidId;
//        tmDevice = String.valueOf(tm.getDev);
//        tmSerial =String.valueOf(tm.getSimCallManager())
//        UUID deviceUuid = new UUID()
//    }
}
