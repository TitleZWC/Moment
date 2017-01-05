package com.titlezwc.moment.common;

import com.titlezwc.moment.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by TitleZWC on 2016/12/25.
 */

@Singleton
public class UIThread implements PostExecutionThread {
    @Inject
    public UIThread() {
    }


    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
