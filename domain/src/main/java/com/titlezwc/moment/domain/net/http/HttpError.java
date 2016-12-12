package com.titlezwc.domain.net.http;

import java.lang.ref.WeakReference;

import rx.Subscriber;

/**
 * Created by TitleZWC on 2016/12/10.
 */

public class HttpError {

    private String mMessage;
    private int mType;
    private String mTitle;
    private String mParams;
    private int mCode;
    private int mStatusCode;
    private WeakReference<Subscriber> mSubscriber;
    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getmParams() {
        return mParams;
    }

    public void setmParams(String mParams) {
        this.mParams = mParams;
    }

    public int getmStatusCode() {
        return mStatusCode;
    }

    public void setmStatusCode(int mStatusCode) {
        this.mStatusCode = mStatusCode;
    }

    public WeakReference<Subscriber> getmSubscriber() {
        return mSubscriber;
    }

    public void setmSubscriber(WeakReference<Subscriber> mSubscriber) {
        this.mSubscriber = mSubscriber;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }


}
