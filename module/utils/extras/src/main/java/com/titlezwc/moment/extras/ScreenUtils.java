package com.titlezwc.moment.extras;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by TitleZWC on 2016/12/25.
 */

public class ScreenUtils {
    private static int screenHeight = 0;
    private static int screenWidth = 0;

    public static int dip2px(Context context, float value) {
        return (int) (0.5F + value * context.getResources().getDisplayMetrics().density);
    }

    public static float dip2px2(Context context, float value) {
        return 0.5F + value * context.getResources().getDisplayMetrics().density;
    }

    public static float dip2sp(Context context, float value) {
        return px2sp(context, dip2px(context, value));
    }

    public static int getScreenHeight(@NonNull Context context) {
        if (screenHeight == 0) {
            setScreenSize(context);
        }
        return screenHeight;
    }

    public static int getScreenWidth(@NonNull Context context) {
        if (screenWidth == 0) {
            setScreenSize((Activity) context);
        }
        return screenWidth;
    }

    public static void hideIme(@NonNull View inputView) {
        ((InputMethodManager) inputView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(inputView.getWindowToken(), 0);
    }

    public static int px2dip(Context context, float value) {
        return (int) (0.5F + value / context.getResources().getDisplayMetrics().density);
    }

    public static int px2sp(Context context, float value) {
        return (int) (0.5F + value / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static void setScreenSize(Activity activity) {
        if ((screenHeight == 0) || (screenWidth == 0)) {
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            screenWidth = localDisplayMetrics.widthPixels;
            screenHeight = localDisplayMetrics.heightPixels;
        }
    }

    public static void setScreenSize(Context context) {
        Point localPoint = new Point();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(localPoint);
            screenWidth = localPoint.x;
            screenHeight = localPoint.y;
//            return;
//        Display localDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
//        screenWidth = localDisplay.getWidth();
//        screenHeight = localDisplay.getHeight();
    }

    public static void showIme(final Context context, final View editView) {
        editView.requestFocus();
        editView.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editView, 2);
            }
        }, 500L);
    }

    public static int sp2px(Context context, float value) {
        return (int) (0.5F + value * context.getResources().getDisplayMetrics().scaledDensity);
    }
}