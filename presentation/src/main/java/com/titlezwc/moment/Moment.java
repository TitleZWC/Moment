package com.titlezwc.moment;

import android.util.Log;

import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.common.application.proxy.listener.ApplicationActionProxyListener;
import com.titlezwc.common.application.proxy.listener.ApplicationProxyListener;
import com.titlezwc.common.view.proxy.listener.ActivityProxyListener;
import com.titlezwc.common.view.proxy.listener.FragmentProxyListener;
import com.titlezwc.data.net.AppInfo;
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

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
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
        return null;
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
