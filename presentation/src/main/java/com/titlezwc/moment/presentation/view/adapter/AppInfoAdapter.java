package com.titlezwc.moment.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.titlezwc.moment.R;
import com.titlezwc.moment.presentation.model.AppInfoModel;
import com.titlezwc.moment.presentation.view.adapter.viewholder.AppInfoHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by TitleZWC on 2016/12/20.
 */
public class AppInfoAdapter extends RecyclerView.Adapter<AppInfoHolder> {
    private OnItemViewClickListener mOnItemViewClickListener;
    private List<AppInfoModel> mList = new ArrayList<>();
    private final LayoutInflater mLayoutInflater;
    private Context mContext;

    @Inject
    public AppInfoAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void refresh(List<AppInfoModel> list) {
        mList = list;
    }

    @Override
    public AppInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AppInfoHolder viewHolder = new AppInfoHolder(mLayoutInflater.inflate(R.layout.view_item_app_info, parent, false));
        viewHolder.setOnItemViewClickListener(mOnItemViewClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AppInfoHolder holder, int position) {
        holder.render(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnItemViewClickListener(OnItemViewClickListener onItemViewClickListener) {
        this.mOnItemViewClickListener = onItemViewClickListener;
    }

    public interface OnItemViewClickListener {
        void onClick(View view, int type);
    }
}
