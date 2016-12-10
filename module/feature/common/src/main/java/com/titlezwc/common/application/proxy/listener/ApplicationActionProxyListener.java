package com.titlezwc.common.application.proxy.listener;

import com.titlezwc.common.AppManager;
import com.titlezwc.domain.net.http.HttpError;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public interface ApplicationActionProxyListener {
    void onForeground();

    void onBackground();

    void onLauncherShow();

    void onExit(AppManager appManager);

    void onAppConfigCenterUpdate();

    void onErrorResult(HttpError httpError);
}
