package com.titlezwc.log.helper;

/**
 * Created by TitleZWC on 2016/11/30.
 */

public class FormattingTuple {
    public static FormattingTuple NULL = new FormattingTuple(null);

    private String message;
    private Throwable throwable;
    private Object[] argArray;

    public FormattingTuple(String message) {
        this(message, null, null);
    }

    public FormattingTuple(String message, Object[] argArray, Throwable throwable) {
        this.argArray = argArray;
        this.throwable = throwable;

        this.message = message;
    }

    static Object[] trimmedCopy(Object[] argArray) {
        if (null == argArray || 0 == argArray.length) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        final int trimmedLen = argArray.length - 1;
        Object[] trimmed = new Object[trimmedLen];
        System.arraycopy(argArray, 0, trimmed, 0, trimmedLen);
        return trimmed;
    }

    public String getMessage() {
        return message;
    }


    public Throwable getThrowable() {
        return throwable;
    }

    public Object[] getArgArray() {
        return argArray;
    }
}
