package com.titlezwc.moment;

import android.util.Log;

import com.titlezwc.common.application.BaseApplication;
import com.titlezwc.log.Logger;
import com.titlezwc.log.printer.LoggerOptions;
import com.titlezwc.log.writer.DatabaseWriter;

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
