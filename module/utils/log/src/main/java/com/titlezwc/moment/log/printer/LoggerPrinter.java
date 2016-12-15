package com.titlezwc.moment.log.printer;


import android.util.Log;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by TitleZWC on 2016/11/30.
 */
public class LoggerPrinter extends Printer {
    public LoggerPrinter(LoggerOptions options) {
        super(options);
        if (options.printEnable) {
            Logger.init(options.tag).logLevel(LogLevel.FULL).methodCount(5).methodOffset(6);
        }
    }

    @Override
    protected void printf(int priority, String message) {
        switch (priority) {
            case Logger.VERBOSE:
                Logger.v(options.tag, message);
                break;
            case Logger.DEBUG:
                Logger.d(options.tag, message);
                break;
            case Logger.INFO:
                Logger.i(options.tag, message);
                break;
            case Logger.WARN:
                Logger.w(options.tag, message);
                break;
            case Logger.ERROR:
                Logger.e(options.tag, message);
                break;
            case Logger.ASSERT:
                Logger.wtf(options.tag, message);
                break;
            default:
                break;
        }
    }

}
