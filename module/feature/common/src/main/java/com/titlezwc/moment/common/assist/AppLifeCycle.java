package com.titlezwc.common.assist;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/8.
 */

public class AppLifeCycle implements AppLifeCycleEvent {

    private boolean mIsBackground = false;

    @Inject
    public AppLifeCycle() {
    }

    public boolean isBackground() {
        return mIsBackground;
    }

    @Override
    public void onAppBackground() {
        mIsBackground = true;
    }

    @Override
    public void onAppForeground() {
        mIsBackground = false;
    }
}
