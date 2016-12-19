package com.titlezwc.moment.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.titlezwc.moment.presentation.view.adapter.viewholder.AppInfoHolder;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/20.
 */
public class AppInfoAdapter extends RecyclerView.Adapter<AppInfoHolder>{
    private OnItemViewClickListener mOnItemViewClickListener;
    @Inject
    public AppInfoAdapter(){}
    @Override
    public AppInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AppInfoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setOnItemViewClickListener(OnItemViewClickListener onItemViewClickListener) {
        this.mOnItemViewClickListener = onItemViewClickListener;
    }

    public interface OnItemViewClickListener{
        void onClick(View view, int type);
    }
}
