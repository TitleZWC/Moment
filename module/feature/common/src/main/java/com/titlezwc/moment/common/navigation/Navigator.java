package com.titlezwc.common.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.titlezwc.common.constant.AnimType;
import com.titlezwc.log.LogUtils;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/12.
 */

public class Navigator {
    @Inject
    public Navigator() {
        LogUtils.d("Inject Navigator init");
    }

    @Deprecated
    public void navigateToOtherPage(@NonNull Context context, Class toPageClass, Intent intent) {
        if (null == intent) {
            intent = new Intent();
        }
        intent.setClass(context, toPageClass);
        context.startActivity(intent);
    }

    @Deprecated
    public void navigateToOtherPage(@NonNull Context context, String toPageClassName, Intent intent) {
        Class toPageClass = getClass(toPageClassName);
        if (null != context && null != toPageClass) {
            LogUtils.d("from = {} to = {}", context, toPageClassName);
            navigateToOtherPage(context, toPageClass, intent);
        } else {
            LogUtils.e("from = {} to = {}", context, toPageClassName);
        }
    }

    @Deprecated
    public void navigateToOtherPageForResult(Activity activity, Class toPageClass, Intent intent, int requestCode) {
        if (null != activity) {
            intent.setClass(activity, toPageClass);
            activity.startActivityForResult(intent, requestCode);
        } else {
            LogUtils.e("from = {} to = {}", activity, toPageClass);
        }
    }

    @Deprecated
    public void navigateToOtherPageForResult(Activity activity, String toPageClassName, Intent intent, int requestCode) {
        Class toPageClass = getClass(toPageClassName);
        if (null != activity && null != toPageClass) {
            LogUtils.d("from = {} to = {}", activity, toPageClassName);
            intent.setClass(activity, toPageClass);
            navigateToOtherPageForResult(activity, toPageClass, intent, requestCode);
        } else {
            LogUtils.e("from = {} to = {}", activity, toPageClassName);
        }
    }

    public void navigateToOtherPage(@NonNull Context context, Class toPageClass, Intent intent, int animType) {
        navigateToOtherPage(context, toPageClass, intent);
        if (context instanceof Activity) {
            withAnim((Activity) context, animType);
        }
    }

    public void navigateToOtherPage(@NonNull Context context, String toPageClassName, Intent intent, int animType) {
        navigateToOtherPage(context, toPageClassName, intent);
        if (context instanceof Activity) {
            withAnim((Activity) context, animType);
        }
    }

    public void navigateToOtherPageForResult(Activity activity, Class toPageClass, Intent intent, int requestCode, int animType) {
        if (null != activity) {
            navigateToOtherPageForResult(activity, toPageClass, intent, requestCode);
            withAnim( activity, animType);
        } else {
            LogUtils.e("from = {} to = {}", activity, toPageClass);
        }
    }

    public void navigateToOtherPageForResult(Activity activity, String toPageClassName, Intent intent, int requestCode, int animType) {
        if (null != activity) {
            navigateToOtherPageForResult(activity, toPageClassName, intent, requestCode);
            withAnim( activity, animType);
        } else {
            LogUtils.e("from = {} to = {}", activity, toPageClassName);
        }
    }

    private void withAnim(Activity activity, int animType) {
        switch (animType) {
            case AnimType.TYPE_TOP2DOWN:
                activity.overridePendingTransition(3, 7);
                break;
            case AnimType.TYPE_LEFT2RIGHT:
                activity.overridePendingTransition(3, 7);
                break;
            case AnimType.TYPE_DOWN2TOP:
                activity.overridePendingTransition(3, 7);
                break;
            case AnimType.TYPE_RIGHT2LEFT:
                activity.overridePendingTransition(3, 7);
                break;
        }
    }

    private Class getClass(String classFullName) {
        try {
            return Class.forName(classFullName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
