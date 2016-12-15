package com.titlezwc.moment.common.application.proxy.listener;

import com.titlezwc.moment.common.AppManager;
import com.titlezwc.moment.domain.net.http.HttpError;

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
