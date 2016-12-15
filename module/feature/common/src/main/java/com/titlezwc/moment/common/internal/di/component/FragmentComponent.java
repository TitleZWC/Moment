package com.titlezwc.moment.common.internal.di.component;

import android.support.v4.app.Fragment;

import com.titlezwc.moment.common.internal.di.modules.FragmentModule;
import com.titlezwc.moment.common.view.fragment.BaseFragment;
import com.titlezwc.moment.domain.internal.di.PerFragment;

import dagger.Component;

/**
 * Created by TitleZWC on 2016/12/14.
 */
@PerFragment
@Component(dependencies = ActivityComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(BaseFragment fragment);
    Fragment fragment();
}
