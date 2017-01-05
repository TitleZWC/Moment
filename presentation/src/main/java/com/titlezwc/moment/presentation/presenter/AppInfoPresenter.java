package com.titlezwc.moment.presentation.presenter;

import com.titlezwc.moment.common.persenter.Persenter;
import com.titlezwc.moment.presentation.view.AppInfoView;

/**
 * Created by TitleZWC on 2016/12/20.
 */

public interface AppInfoPresenter extends Persenter{
    void setView(AppInfoView view);

    void getAppsList();
}
