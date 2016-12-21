package com.titlezwc.moment.presentation.view;

import android.content.Context;

import com.titlezwc.moment.presentation.model.AppInfoModel;

import java.util.List;

/**
 * Created by TitleZWC on 2016/12/20.
 */

public interface AppInfoView {
    Context getContext();

    void onAppsListGot(List<AppInfoModel> appsInfo);
}
