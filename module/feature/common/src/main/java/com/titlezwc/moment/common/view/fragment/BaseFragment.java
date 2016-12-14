package com.titlezwc.moment.common.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.titlezwc.moment.common.internal.di.HasComponent;
import com.titlezwc.moment.common.internal.di.component.ActivityComponent;
import com.titlezwc.moment.common.internal.di.component.FragmentComponent;
import com.titlezwc.moment.common.internal.di.component.DaggerFragmentComponent;
import com.titlezwc.moment.common.internal.di.modules.FragmentModule;
import com.titlezwc.moment.common.navigation.Navigator;
import com.titlezwc.moment.common.view.activity.BaseActivity;
import com.titlezwc.moment.common.view.proxy.FragmentProxy;
import com.titlezwc.moment.log.LogUtils;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/10.
 */

public abstract class BaseFragment extends Fragment implements HasComponent<FragmentComponent> {
    @Inject
    protected FragmentProxy mFragmentProxy;
    @Inject
    protected Navigator mNavigator;
    @Inject
    protected Handler mHandle;
    private FragmentComponent mComponent;
    private final String mSimpleName = getClass().getSimpleName();

    protected void initializeInjector() {
        LogUtils.d("{}:initializeInjector", mSimpleName);
        mComponent = DaggerFragmentComponent.builder()
                .activityComponent(getActivityComponent())
                .fragmentModule(getFragmentModule())
                .build();
        mComponent.inject(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initializeInjector();
        LogUtils.d("{}:onAttach", mSimpleName);
        mFragmentProxy.onAttach(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("{}:onCreate savedInstanceState = {}", mSimpleName,savedInstanceState);
        mFragmentProxy.onCreate(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.d("{}:onCreateView savedInstanceState = {}", mSimpleName,savedInstanceState);
        mFragmentProxy.onCreateView(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.d("{}:onViewCreated savedInstanceState = {}", mSimpleName,savedInstanceState);
        mFragmentProxy.onViewCreated(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.d("{}:onActivityCreated", mSimpleName);
        mFragmentProxy.onActivityCreated(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.d("{}:onStart", mSimpleName);
        mFragmentProxy.onStart(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d("{}:onResume", mSimpleName);
        mFragmentProxy.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d("{}:onPause", mSimpleName);
        mFragmentProxy.onPause(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.d("{}:onStop", mSimpleName);
        mFragmentProxy.onStop(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.d("{}:onDestroyView", mSimpleName);
        mFragmentProxy.onDestroyView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d("{}:onDestroy", mSimpleName);
        mFragmentProxy.onDestroy(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.d("{}:onDetach", mSimpleName);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.d("{}:onConfigurationChanged", mSimpleName);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.d("{}:onActivityResult", mSimpleName);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        LogUtils.d("{}:onCreateContextMenu", mSimpleName);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.d("{}:onLowMemory", mSimpleName);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.d("{}:onAttach", mSimpleName);
        mFragmentProxy.onAttach(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LogUtils.d("{}:onRequestPermissionsResult", mSimpleName);
    }

    private final ActivityComponent getActivityComponent() {
        return ((BaseActivity) getActivity()).getComponent();
    }

    @Override
    public FragmentComponent getComponent() {
        return mComponent;
    }

    private FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }
}
