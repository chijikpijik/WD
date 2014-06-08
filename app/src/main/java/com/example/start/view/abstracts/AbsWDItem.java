package com.example.start.view.abstracts;

import android.net.Uri;

import java.net.URI;

public abstract class AbsWDItem {

    private String mTitle;
    private String mRate;
    private URI mImageUri;
    private String mDataType;

    public AbsWDItem() {
    }

    public void setDataType(String type) {
        mDataType = type;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setRate(String rate) {
        mRate = rate;
    }

    public void setImageUri(URI uri) {
        mImageUri = uri;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getRate() {
       return mRate;
    }

    public URI getImageUri() {
        return mImageUri;
    }
}
