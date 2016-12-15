package com.titlezwc.moment.presentation.view;

import android.os.Bundle;

import com.titlezwc.moment.common.view.activity.BaseActivity;
import com.titlezwc.moment.log.LogUtils;
import com.titlezwc.moment.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.d("LogUtils :{}", "onCreate");
    }
}
