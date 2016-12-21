package com.titlezwc.moment.presentation.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.titlezwc.moment.common.view.activity.BaseActivity;
import com.titlezwc.moment.R;
import com.titlezwc.moment.presentation.internal.di.components.DaggerAppInfoActivityComponent;
import com.titlezwc.moment.presentation.internal.di.modules.AppInfoActivityModule;
import com.titlezwc.moment.presentation.model.AppInfoModel;
import com.titlezwc.moment.presentation.presenter.AppInfoPresenter;
import com.titlezwc.moment.presentation.view.AppInfoView;
import com.titlezwc.moment.presentation.view.adapter.AppInfoAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements AppInfoView, AppInfoAdapter.OnItemViewClickListener {
    @BindView(R.id.lv_appInfo)
    protected RecyclerView mRecyclerView;
    @Inject
    protected AppInfoAdapter mAppInfoAdapter;
    @Inject
    protected AppInfoPresenter mPresenter;
    private List<AppInfoModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter.setView(this);
        initRecyclerView();
        mPresenter.getAppsList();
    }

    @Override
    protected void initializeInjector() {
        super.initializeInjector();
        DaggerAppInfoActivityComponent.builder()
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .appInfoActivityModule(new AppInfoActivityModule())
                .build().inject(this);
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        mAppInfoAdapter.setOnItemViewClickListener(this);
        mRecyclerView.setAdapter(mAppInfoAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view, int type) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onAppsListGot(List<AppInfoModel> appsInfo) {
        if (null != appsInfo && !appsInfo.isEmpty()) {
            mList.clear();
            mList.addAll(appsInfo);
            ((AppInfoAdapter) mRecyclerView.getAdapter()).refresh(mList);
        }
    }
}
