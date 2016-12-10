package com.titlezwc.moment;

import android.os.Build;
import android.util.Log;

import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.application.proxy.listener.ApplicationActionProxyListener;
import com.titlezwc.common.application.proxy.listener.ApplicationProxyListener;
import com.titlezwc.common.utils.AppUtils;
import com.titlezwc.common.view.proxy.listener.ActivityProxyListener;
import com.titlezwc.common.view.proxy.listener.FragmentProxyListener;
import com.titlezwc.data.net.AppInfo;
import com.titlezwc.log.LogUtils;
import com.titlezwc.log.Logger;
import com.titlezwc.log.printer.LoggerOptions;
import com.titlezwc.log.writer.DatabaseWriter;
import com.titlezwc.moment.presentation.proxy.impl.ActivityProxyImpl;
import com.titlezwc.moment.presentation.proxy.impl.ApplicationActionProxyImpl;
import com.titlezwc.moment.presentation.proxy.impl.ApplicationProxyImpl;
import com.titlezwc.moment.presentation.proxy.impl.FragmentProxyImpl;

/**
 * Created by Administrator on 2016/11/28.
 */

public class Moment extends BaseApplication {
    public static final boolean DEBUG = BuildConfig.MOMENT_DEBUG;
    private String mProcessName = null;

    @Override
    public void onCreate() {
        initLog();
        super.onCreate();
        mProcessName = AppUtils.getProcessName(this);
    }

    @Override
    protected ApplicationProxyListener getApplicationProxyListener() {
        return new ApplicationProxyImpl(this);
    }

    @Override
    protected ActivityProxyListener getActivityProxyListener() {
        return new ActivityProxyImpl(this);
    }

    @Override
    protected FragmentProxyListener getFragmentProxyListener() {
        return new FragmentProxyImpl(this);
    }

    @Override
    protected ApplicationActionProxyListener getApplicationActionProxyListener() {
        return new ApplicationActionProxyImpl(this);
    }

    @Override
    protected AppInfo getAppInfo() {
        AppInfo appInfo = new AppInfo();
        appInfo.setLang(AppUtils.getLanguage(this));
        LogUtils.d("language:{}", AppUtils.getLanguage(this));
        appInfo.setOs("android");
        appInfo.setAppVer(BuildConfig.VERSION_NAME);
        appInfo.setChannel(BuildConfig.FLAVOR);
        appInfo.setDevice(Build.MODEL);
        appInfo.setDeviceVersion(Build.VERSION.RELEASE);
//        appInfo.setUuid(getUUID());
        appInfo.setRoot(AppUtils.isRootSystem());
        appInfo.setStartTs(System.currentTimeMillis());
        appInfo.setProcessName(mProcessName);
        appInfo.setDebug(BuildConfig.DEBUG);
        appInfo.setAppVersionCode(BuildConfig.VERSION_CODE);
        return appInfo;
    }

    @Override
    protected boolean debugEnable() {
        return DEBUG;
    }

    private void initLog() {
        boolean buildType = DEBUG && BuildConfig.DEBUG;
        Logger.init(new LoggerOptions.Builder().logLevel(buildType ? Log.VERBOSE : Log.ERROR)
                .addDatabaseWriter(new DatabaseWriter())
                .printEnable(buildType)
                .writeEnable(buildType)
                .build());
    }
}
