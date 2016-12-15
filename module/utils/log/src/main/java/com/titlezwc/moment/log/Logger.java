package com.titlezwc.moment.log;

import android.util.Log;

import com.titlezwc.moment.log.printer.LoggerOptions;
import com.titlezwc.moment.log.printer.Printer;
import com.titlezwc.moment.log.printer.PrinterFactory;

import org.json.JSONObject;

/**
 * Created by TitleZWC on 2016/11/29.
 */

public class Logger {
    private static Printer printer = PrinterFactory.createPrinter(new LoggerOptions.Builder().build());
    private static String tag = "moment";

    private Logger() {
    }

    public static void init(LoggerOptions options) {
        init(PrinterFactory.PRINT_ANDROID, options);
    }

    public static void init(String type, LoggerOptions options) {
        printer = PrinterFactory.createPrinter(type, options);
    }

    public static void initDefault(boolean debug) {
        Logger.init(PrinterFactory.PRINT_ANDROID, new LoggerOptions.Builder().logLevel(debug ? Log.VERBOSE : Log.ERROR).tag(tag).printEnable(debug).writeEnable(debug).build());
    }

    public static void e(String message, Object... args) {
        printer.e(message, args);
    }

    public static void e(boolean record, String message, Object... args) {
        printer.e(record, message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        printer.e(throwable, message, args);
    }

    public static void e(boolean record, Throwable throwable, String message, Object... args) {
        printer.e(record, throwable, message, args);
    }

    public static void w(String message, Object... args) {
        printer.w(message, args);
    }

    public static void w(boolean record, String message, Object... args) {
        printer.w(record, message, args);
    }

    public static void d(String message, Object... args) {
        printer.d(message, args);
    }

    public static void d(boolean record, String message, Object... args) {
        printer.d(record, message, args);
    }

    public static void i(String message, Object... args) {
        printer.i(message, args);
    }

    public static void i(boolean record, String message, Object... args) {
        printer.i(record, message, args);
    }

    public static void v(String message, Object... args) {
        printer.v(message, args);
    }

    public static void v(boolean record, String message, Object... args) {
        printer.v(record, message, args);
    }

    public static void wtf(String message, Object... args) {
        printer.wtf(message, args);
    }

    public static void wtf(boolean record, String message, Object... args) {
        printer.wtf(record, message, args);
    }

    public static void wtf(Throwable throwable) {
        printer.wtf(throwable);
    }

    public static void wtf(boolean record, Throwable throwable, String message, Object... args) {
        printer.wtf(record, throwable, message, args);
    }

    public static void json(String json) {
        printer.json(json);
    }


    public static void xml(String xml) {
        printer.json(xml);
    }
}
