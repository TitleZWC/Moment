package com.titlezwc.common.internal.di.modules;

import android.app.Activity;

import com.titlezwc.domain.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TitleZWC on 2016/12/12.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
