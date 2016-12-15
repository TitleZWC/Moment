package com.titlezwc.moment.log.printer;

/**
 * Created by TitleZWC on 2016/11/29.
 */

public class PrinterFactory {
    public static final  String PRINT_ANDROID = "Android";
    public static final  String PRINT_LOGGER = "Logger";
    public static final  String PRINT_TINBER = "Timber";

    public static Printer createPrinter(LoggerOptions options) {
        return createPrinter(null,options);
    }

    public static Printer createPrinter(String type,LoggerOptions options) {
        Printer printer;
        if(PRINT_TINBER.equals(type)&&isClassExists("timber.log.Timber")){
            printer = new TimberPrinter(options);
        }else  if(PRINT_LOGGER.equals(type)&&isClassExists("com.grhanobut.logger.Logger")){
            printer = new LoggerPrinter(options);
        }else if(PRINT_ANDROID.equals(type)){
            printer = new AndroidPrinter(options);

        }else {
            printer = new DefaultPrinter(options);
        }
        return printer;
    }

    private static boolean isClassExists(String classFullName){
        try {
            Class.forName(classFullName);
            return true;
        }catch (ClassNotFoundException e){
            return false;
        }
    }
}
