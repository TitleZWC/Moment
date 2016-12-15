package com.titlezwc.moment;

import android.os.Build;
import android.util.Log;

import com.titlezwc.moment.common.application.BaseApplication;
import com.titlezwc.moment.common.application.proxy.listener.ApplicationActionProxyListener;
import com.titlezwc.moment.common.application.proxy.listener.ApplicationProxyListener;
import com.titlezwc.moment.common.utils.AppUtils;
import com.titlezwc.moment.common.view.proxy.listener.ActivityProxyListener;
import com.titlezwc.moment.common.view.proxy.listener.FragmentProxyListener;
import com.titlezwc.moment.data.net.AppInfo;
import com.titlezwc.moment.log.LogUtils;
import com.titlezwc.moment.log.Logger;
import com.titlezwc.moment.log.printer.LoggerOptions;
import com.titlezwc.moment.log.writer.DatabaseWriter;
import com.titlezwc.moment.presentation.proxy.impl.ActivityProxyImpl;
import com.titlezwc.moment.presentation.proxy.impl.ApplicationActionProxyImpl;
import com.titlezwc.moment.presentation.proxy.impl.ApplicationProxyImpl;
import com.titlezwc.moment.presentation.proxy.impl.FragmentProxyImpl;
import com.umeng.analytics.MobclickAgent;

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

    private void initUmeng() {
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this, "5853147f1061d21be7002746", BuildConfig.FLAVOR));
    }
}
