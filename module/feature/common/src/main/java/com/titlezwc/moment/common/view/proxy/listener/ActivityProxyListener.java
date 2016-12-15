package com.titlezwc.moment.common.view.proxy.listener;

import android.content.Intent;
import android.os.Bundle;

import com.titlezwc.moment.common.view.activity.BaseActivity;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public interface ActivityProxyListener {
    void onCreate(BaseActivity activity, Bundle saveInstanceState);

    void onStart(BaseActivity activity);

    void onRestart(BaseActivity activity);

    void onStop(BaseActivity activity);

    void onResume(BaseActivity activity);

    void onPause(BaseActivity activity);

    void onDestroy(BaseActivity activity);

    void onLowMemory(BaseActivity activity);

    void startActivity(BaseActivity activity, Intent intent);

    void startActivityForResult(BaseActivity activity, Intent intent, int requestCode, Bundle options);
}
