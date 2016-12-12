package com.titlezwc.common;

import android.app.Activity;
import android.content.Context;

import com.titlezwc.log.LogUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by TitleZWC on 2016/12/8.
 */
@Singleton
public class AppManager {
    private Stack<Activity> activityStack = new Stack<>();

    @Inject
    public AppManager() {
        LogUtils.d("Inject AppManager init");
    }

    /**
     * 添加Activity到堆栈
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    public Activity currentActivity() {

        if (!activityStack.isEmpty()) { //TODO isEmpty()与empty()的区别
            return activityStack.lastElement();
        } else {
            return null;
        }
    }

    public void finishActivity() {
        if (!activityStack.empty()) {
            Activity activity = activityStack.lastElement();
            finishActivity(activity);
        }

    }

    public void finishActivity(Activity activity) {
        if (null != activity && !activityStack.empty()) {
            activityStack.remove(activity);
            finishActivity(activity);
        }
    }

    public void finishOtherActivities(Activity... activities) {
        Comparator<Activity> comparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1 == o2 ? 0 : -1;
            }
        };
        int size = activityStack.size();
        for (int i = 0; i < size; i++) {
            Activity activity = activityStack.get(i);
            if (null != activities && 0 > Arrays.binarySearch(activities, activity, comparator)) {
                activityStack.remove(activity);
                activity.finish();
            }
        }
    }

    public void finishOtherActivities(Class<?>... classes) {
        Comparator<Class<?>> comparator = new Comparator<Class<?>>() {
            @Override
            public int compare(Class<?> o1, Class<?> o2) {
                return o1 == o2 ? 0 : -1;
            }
        };
        int size = activityStack.size();
        for (int i = 0; i < size; i++) {
            Activity activity = activityStack.get(i);
            if (null != activity && 0 > Arrays.binarySearch(classes, activity.getClass(), comparator)) {
                activityStack.remove(activity);
                activity.finish();
            }
        }
    }

    private Activity getActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (cls.equals(activity.getClass())) {
                return activity;
            }
        }
        return null;
    }

    private boolean existsActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (cls.equals(activity.getClass())) {
                return true;
            }
        }
        return false;
    }

    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    public void finishAllActivity() {
        int size = activityStack.size();
        for (int i = 0; i < size; i++) {
            Activity activity = activityStack.get(i);
            if (null != activity && !activity.isFinishing()) {
                activity.finish();

            }
        }
        activityStack.clear();
    }

    public void appExit(Context context) {
        try {
            finishAllActivity();
            int pid = android.os.Process.myPid();
            android.os.Process.killProcess(pid);
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeActivity(Activity activity) {
        if (null != activity && activityStack.empty()) {
            activityStack.remove(activity);
        }
    }

    public void updateCurrentActivity(Activity activity) {
        if (!activityStack.empty()) {
            Activity lastActivity = activityStack.lastElement();
            if (null != activity && activity != lastActivity) {
                removeActivity(activity);
                addActivity(activity);
            }
        }
    }

    public int activityCount() {
        return activityStack.size();
    }

    public Stack<Activity> getActivityStack() {
        return activityStack;
    }
}
