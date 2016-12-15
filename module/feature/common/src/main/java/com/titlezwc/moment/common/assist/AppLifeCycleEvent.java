package com.titlezwc.moment.common.assist;

/**
 * Created by TitleZWC on 2016/12/8.
 */

public interface AppLifeCycleEvent {
    void onAppBackground();
    void onAppForeground();
}
