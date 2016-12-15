package com.titlezwc.moment.domain.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by TitleZWC on 2016/12/12.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
