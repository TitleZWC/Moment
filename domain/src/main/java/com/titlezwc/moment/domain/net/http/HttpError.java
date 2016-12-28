package com.titlezwc.moment.domain.net.http;

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
    public int getCode() {
        return mCode;
    }

    public void setCode(int mCode) {
        this.mCode = mCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getParams() {
        return mParams;
    }

    public void setParams(String mParams) {
        this.mParams = mParams;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(int mStatusCode) {
        this.mStatusCode = mStatusCode;
    }

    public WeakReference<Subscriber> getSubscriber() {
        return mSubscriber;
    }

    public void setSubscriber(WeakReference<Subscriber> mSubscriber) {
        this.mSubscriber = mSubscriber;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }


}
