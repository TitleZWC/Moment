package com.titlezwc.log.printer;

import android.text.TextUtils;
import android.util.Log;

import com.titlezwc.log.helper.MessageFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by TitleZWC on 2016/11/29.
 */

public abstract class Printer {
    protected final LoggerOptions options;

    private static final String FILE_TYPE = ".java";

    public Printer(LoggerOptions options) {
        this.options = options;
    }

    public void e(boolean record, Throwable throwable) {
        if (checkPriority(Log.ERROR, record)) {
            if (null != throwable) {
                String message = "throwable".concat(throwable.toString());
                printf(record, Log.ERROR, message);
            }
        }
    }

    protected void printf(boolean record, int priority, String message, Object... args) {
        if (checkPriority(priority, record)) {
            if (options.printEnable || options.writeEnable || record) {
                message = createMessage(message, args);
                //标准输出
                if (options.printEnable) {
                    printf(priority, message);
                }
                //文本输出
                if (options.writeEnable && null != options.textWriter) {
                    options.textWriter.write(priority, message);
                }
                //数据库
                if (record) {
                    write(priority, message);
                }
            }
        }
    }

    private String createMessage(String message, Object... args) {
        StackTraceElement stackTrace = (new Throwable()).getStackTrace()[options.stackTraceLevel];
        String methodName = stackTrace.getMethodName();
        String fileName = stackTrace.getFileName();
        if (null == fileName) {
            fileName = stackTrace.getClassName();
        }
        int lineNumber = stackTrace.getLineNumber();
        if (null != fileName && fileName.contains(FILE_TYPE)) {
            fileName = fileName.replace(FILE_TYPE, "");
        }

        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
        df.setLenient(false);
        Calendar cal = Calendar.getInstance();
        String curTime = df.format(cal.getTime());

        int pid = android.os.Process.myPid();
        int tid = android.os.Process.myTid();

        String aMessage = (null == args || args.length == 0) ? message : MessageFormatter.arrayFormat(message, args).getMessage();
        String output;
        if (options.showMethod) {
            output = String.format(Locale.getDefault(), "%s pid=%d tid=%d <%s: %s: %d> %s", curTime, pid, tid, fileName, methodName, lineNumber, aMessage);
        } else {
            output = String.format(Locale.getDefault(), "%s: pid=%d tid=%d <%s: %s> %s", curTime, pid, tid, fileName, lineNumber, aMessage);
        }
        return output;
    }

    public void e(String message, Object... args) {

        printf(false, Log.ERROR, message, args);
    }

    protected abstract void printf(int priority, String message);


    public void e(boolean record, String message, Object... args) {
        printf(record, Log.ERROR, message, args);
    }

    public void e(Throwable throwable, String message, Object... args) {
        this.e(false, throwable, message, args);
    }

    public void e(Throwable throwable) {
        this.e(false, throwable);
    }

    public void e(boolean record, Throwable throwable, String message, Object... args) {
        if (checkPriority(Log.ERROR, record)) {
            if (null != throwable && null != message) {
                message = message + ":" + throwable.toString();
            }
            printf(record, Log.ERROR, message, args);
        }
    }

    public void w(String message, Object... args) {
        this.w(false, message, args);
    }

    public void w(boolean record, String message, Object... args) {
        printf(record, Log.WARN, message, args);
    }

    public void d(String message, Object... args) {
        this.d(false, message, args);
    }

    public void d(boolean record, String message, Object... args) {
        printf(record, Log.DEBUG, message, args);
    }

    public void i(String message, Object... args) {
        this.i(false, message, args);
    }

    public void i(boolean record, String message, Object... args) {
        printf(record, Log.INFO, message, args);
    }

    public void v(String message, Object... args) {
        this.v(false, message, args);
    }

    public void v(boolean record, String message, Object... args) {
        printf(record, Log.VERBOSE, message, args);
    }

    public void wtf(String message, Object... args) {
        this.wtf(false, message, args);
    }

    public void wtf(boolean record, String message, Object... args) {
        printf(record, Log.ASSERT, message, args);
    }

    public void wtf(Throwable throwable) {
        this.wtf(false, throwable);
    }

    public void wtf(boolean record, Throwable throwable) {
        if (checkPriority(Log.ASSERT, record)) {
            if (null != throwable) {
                printf(record, Log.ASSERT, "throwable : " + throwable.toString());
            }
        }
    }
    public void wtf( Throwable throwable, String message, Object... args) {
        this.wtf(false,throwable,message,args);
    }
    public void wtf(boolean record, Throwable throwable, String message, Object... args) {
        if (checkPriority(Log.ASSERT, record)) {
            if (null != throwable) {
               message =  "throwable : " + throwable.toString();
            }
            printf(record, Log.ASSERT,message,args);
        }
    }

    public void json(String json) {
        if (checkPriority(Log.DEBUG, false)) {
            if (TextUtils.isEmpty(json)) {
                printf(Log.DEBUG, "Empty/Null json content");
            } else {
                try {
                    String message;
                    if (json.startsWith("{")) {
                        JSONObject e1 = new JSONObject(json);
                        message = e1.toString(4);
                        printf(Log.DEBUG, message);
                        return;
                    }

                    if (json.startsWith("[")) {
                        JSONArray e = new JSONArray(json);
                        message = e.toString(4);
                        printf(Log.DEBUG, message);
                    }
                } catch (JSONException var4) {
                    if (null != var4.getCause()) {
                        printf(Log.ERROR, var4.getCause().getMessage() + "\n" + json);
                    }
                    var4.printStackTrace();
                }
            }
        }
    }

    public void xml(String xml) {
        if (checkPriority(Log.DEBUG, false)) {
            if (TextUtils.isEmpty(xml)) {
                printf(Log.DEBUG, "Empty/Null xml content");
            } else {
                try {
                    StreamSource e = new StreamSource(new StringReader(xml));
                    StreamResult xmlOutput = new StreamResult(new StringWriter());
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty("indent", "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    transformer.transform(e, xmlOutput);
                    printf(Log.DEBUG, xmlOutput.getWriter().toString().replaceFirst(">", ">\n"));
                } catch (TransformerException var5) {
                    printf(Log.ERROR, var5.getCause().getMessage() + "\n" + xml);
                }
            }
        }
    }


    protected void write(int priority, String message) {

        if (null != options.databaseWriter) {
            options.databaseWriter.write(priority, message);
        }
    }

    private boolean checkPriority(int level, boolean record) {
        return options.priority <= level || record;
    }
}
