package com.titlezwc.moment.presentation.view;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.titlezwc.moment.common.view.activity.BaseActivity;
import com.titlezwc.moment.log.LogUtils;
import com.titlezwc.moment.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_text)
    protected TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTextView.setText("this is main Activity");
        mTextView.setOnClickListener(v -> Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show());
        LogUtils.d("LogUtils :{}", "onCreate");
    }
}
