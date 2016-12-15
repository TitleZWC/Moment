package com.titlezwc.moment.common.internal.di.modules;

import android.support.v4.app.Fragment;

import com.titlezwc.moment.domain.internal.di.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TitleZWC on 2016/12/14.
 */
@Module
public class FragmentModule {
    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment fragment() {
        return fragment;
    }
}
