package com.titlezwc.common.view.proxy.listener;


import com.titlezwc.common.view.fragment.BaseFragment;

/**
 * Created by TitleZWC on 2016/12/9.
 */

public interface FragmentProxyListener {
    void onCreate(BaseFragment fragment);

    void onCreateView(BaseFragment fragment);

    void onActivityCreated(BaseFragment fragment);

    void onViewCreated(BaseFragment fragment);

    void onAttach(BaseFragment fragment);

    void onDestroy(BaseFragment fragment);

    void onResume(BaseFragment fragment);

    void onPause(BaseFragment fragment);

    void onStart(BaseFragment fragment);

    void onStop(BaseFragment fragment);

    void onDestroyView(BaseFragment fragment);
}
