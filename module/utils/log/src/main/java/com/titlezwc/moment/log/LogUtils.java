package com.titlezwc.log;

import android.text.TextUtils;

import org.json.JSONObject;

/**
 * Created by TitleZWC on 2016/11/29.
 */

public final class LogUtils {
    public static void e(String message, Object... args) {
        Logger.e(message, args);
    }

    public static void e(boolean record, String message, Object... args) {
        Logger.e(record, message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        Logger.e(throwable, message, args);
    }

    public static void e(boolean recoder, Throwable throwable, String message, Object... args) {
        Logger.e(recoder, throwable, message, args);
    }

    public static void w(String message, Object... args) {
        Logger.w(message, args);
    }

    public static void w(boolean record, String message, Object... args) {
        Logger.w(record, message, args);
    }

    public static void d(String message, Object... args) {
        Logger.d(message, args);
    }

    public static void d(boolean record, String message, Object... args) {
        Logger.d(record, message, args);
    }

    public static void i(String message, Object... args) {
        Logger.i(message, args);
    }

    public static void i(boolean record, String message, Object... args) {
        Logger.i(record, message, args);
    }

    public static void v(String message, Object... args) {
        Logger.v(message, args);
    }

    public static void v(boolean record, String message, Object... args) {
        Logger.v(record, message, args);
    }

    public static void wtf(String message, Object... args) {
        Logger.wtf(message, args);
    }

    public static void wtf(boolean record, String message, Object... args) {
        Logger.wtf(record, message, args);
    }

    public static void wtf(Throwable throwable) {
        Logger.wtf(throwable);
    }

    public static void wtf(boolean record, Throwable throwable, String message, Object... args) {
        Logger.wtf(record, throwable, message, args);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void json(JSONObject json) {
        if(null!=json&&!TextUtils.isEmpty(json.toString()))
        Logger.json(json.toString());
    }

    public static void xml(String xml) {
        Logger.json(xml);
    }

}
