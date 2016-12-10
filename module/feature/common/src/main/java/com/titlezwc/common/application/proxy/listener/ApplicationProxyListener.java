package com.titlezwc.common.application.proxy.listener;

import android.content.res.Configuration;

/**
 * Created by TitleZWC on 2016/12/8.
 */

public interface ApplicationProxyListener {
    void onCreate(String processName);

    void onLowMemory();

    void onTerminate();

    void onTrimMemory(int level);

    void onConfigurationChanged(Configuration newConfig);
}
