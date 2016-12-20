package com.titlezwc.moment.presentation.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.titlezwc.moment.R;
import com.titlezwc.moment.presentation.constant.ClickType;
import com.titlezwc.moment.presentation.model.AppInfoModel;
import com.titlezwc.moment.presentation.view.adapter.AppInfoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TitleZWC on 2016/12/20.
 */
public class AppInfoHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.im_app_icon)
    protected ImageView mIcon;
    @BindView(R.id.tv_app_name)
    protected TextView mAppName;

    private AppInfoAdapter.OnItemViewClickListener mOnItemViewClickListener;

    public AppInfoHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setOnItemViewClickListener(AppInfoAdapter.OnItemViewClickListener mOnItemViewClickListener) {
        this.mOnItemViewClickListener = mOnItemViewClickListener;
    }

    public void render(AppInfoModel appInfoModel) {
        mAppName.setText(appInfoModel.getAppName());
        mIcon.setImageDrawable(appInfoModel.getIcon());
        itemView.setOnClickListener(v -> mOnItemViewClickListener.onClick(v, ClickType.TYPE_APP_INFO_ITEM_CLICK));
    }
}
