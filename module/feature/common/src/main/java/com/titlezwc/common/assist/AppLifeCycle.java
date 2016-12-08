package com.titlezwc.common.assist;

/**
 * Created by TitleZWC on 2016/12/8.
 */

public class AppLifeCycle implements  AppLifeCycleEvent{

    private  boolean mIsBackground = false;

    public boolean isBackground(){
        return mIsBackground;
    }
    @Override
    public void onAppBackground() {
        mIsBackground =true;
    }

    @Override
    public void onAppForeground() {
        mIsBackground = false;
    }
}
