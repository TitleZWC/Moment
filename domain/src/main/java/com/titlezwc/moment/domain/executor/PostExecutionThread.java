package com.titlezwc.moment.domain.executor;

import rx.Scheduler;

/**
 * Created by TitleZWC on 2016/12/25.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
