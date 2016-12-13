package com.titlezwc.moment.log.printer;

import android.text.TextUtils;
import android.util.Log;

import com.titlezwc.moment.log.writer.DatabaseWriter;
import com.titlezwc.moment.log.writer.DefaultWriter;
import com.titlezwc.moment.log.writer.TextWriter;
import com.titlezwc.moment.log.writer.Writer;

/**
 * Created by TitleZWC on 2016/11/29.
 */

public class LoggerOptions {
    private static final String DEFAULT_TAG = "momet";

    final Writer textWriter;
    final Writer databaseWriter;
    final int priority;             //log的级别
    final String tag;               //log的tag
    final int stackTraceLevel;      //堆栈深度
    final boolean showMethod;       //是否展示调用的方法名
    final boolean printEnable;      //允许打印log
    final boolean writeEnable;      //允许写log

    public LoggerOptions(final Builder builder) {
        this.textWriter = builder.textWriter;
        this.databaseWriter = builder.databaseWriter;
        this.priority = builder.priority;
        this.tag = builder.tag;
        this.stackTraceLevel = builder.stackTraceLevel;
        this.showMethod = builder.showMethod;
        this.printEnable = builder.printEnable;
        this.writeEnable = builder.writeEnable;
    }

    public static class Builder {
        private Writer textWriter;
        private Writer databaseWriter;
        private int priority = -1;               //log的级别
        private String tag;                      //log的tag
        private int stackTraceLevel = 6;         //FIXME 默认值，获取调用log的方法名，除非改变printer的包结构，否则不改此值
        private boolean showMethod = true;       //是否展示调用的方法名
        private boolean printEnable = false;     //允许打印log
        private boolean writeEnable = false;     //允许写log

        public LoggerOptions build() {
            initEmptyFieldsWithDefaultValues();
            return new LoggerOptions(this);
        }

        public Builder addTextWriter(TextWriter textWriter) {
            this.textWriter = textWriter;
            return this;
        }
        public Builder addDatabaseWriter(DatabaseWriter databaseWriter) {
            this.databaseWriter = databaseWriter;
            return this;
        }

        public Builder logLevel(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }
        public Builder stackTraceLevel(int stackTraceLevel) {
            this.stackTraceLevel = stackTraceLevel;
            return this;
        }
        public Builder showMethod(boolean showMethod) {
            this.showMethod = showMethod;
            return this;
        }


        public Builder printEnable(boolean printEnable) {
            this.printEnable = printEnable;
            return this;
        }

        public Builder writeEnable(boolean writeEnable) {
            this.writeEnable = writeEnable;
            return this;
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (null == databaseWriter) {
                databaseWriter = new DefaultWriter();
            }
            if (null == textWriter) {
                databaseWriter = new DefaultWriter();
            }
            if (priority < 0) {
                priority = Log.ASSERT + 1;//no log
            }
            if (TextUtils.isEmpty(tag)) {
                tag = DEFAULT_TAG;
            }
        }
    }
}
