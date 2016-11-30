package com.titlezwc.moment;

import android.os.Bundle;
import android.util.Log;

import com.titlezwc.common.BaseActivity;
import com.titlezwc.log.LogUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.d("LogUtils :{}", "onCreate");
    }
}
