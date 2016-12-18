package com.titlezwc.moment.presentation.view;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * Created by TitleZWC on 2016/12/19.
 */
public class AppInfo {
    private Long id;
    private String packageName;
    private String appName;
    private String VersionName;
    private int versionCode;
    private int openTimes;
    private long useTime;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    private Drawable icon;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOpenTimes() {
        return openTimes;
    }

    public void setOpenTimes(int openTimes) {
        this.openTimes = openTimes;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return VersionName;
    }

    public void setVersionName(String versionName) {
        VersionName = versionName;
    }

    private Date date;
}
