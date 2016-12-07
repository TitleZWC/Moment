package com.titlezwc.log.printer;

import android.util.Log;


import timber.log.Timber;

/**
 * Created by TitleZWC on 2016/11/30.
 */
public class TimberPrinter extends Printer {
    public TimberPrinter(LoggerOptions options) {
        super(options);
        if(options.printEnable){
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected void printf(int priority, String message) {
        switch (priority) {
            case Log.VERBOSE:
                Timber.tag(options.tag).v( message);
                break;
            case Log.DEBUG:
                Timber.tag(options.tag).d( message);
                break;
            case Log.INFO:
                Timber.tag(options.tag).i( message);
                break;
            case Log.WARN:
                Timber.tag(options.tag).w( message);
                break;
            case Log.ERROR:
                Timber.tag(options.tag).e( message);
                break;
            case Log.ASSERT:
                Timber.tag(options.tag).wtf( message);
                break;
            default:
                break;
        }
    }
}
