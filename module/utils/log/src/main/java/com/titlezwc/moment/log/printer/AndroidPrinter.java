package com.titlezwc.log.printer;

import android.util.Log;

/**
 * Created by TitleZWC on 2016/11/30.
 */
public class AndroidPrinter extends Printer {
    public AndroidPrinter(LoggerOptions options) {
        super(options);
    }

    @Override
    protected void printf(int priority, String message) {
        switch (priority) {
            case Log.VERBOSE:
                Log.v(options.tag, message);
                break;
            case Log.DEBUG:
                Log.d(options.tag, message);
                break;
            case Log.INFO:
                Log.i(options.tag, message);
                break;
            case Log.WARN:
                Log.w(options.tag, message);
                break;
            case Log.ERROR:
                Log.e(options.tag, message);
                break;
            case Log.ASSERT:
                Log.wtf(options.tag, message);
                break;
            default:
                break;
        }
    }
}
