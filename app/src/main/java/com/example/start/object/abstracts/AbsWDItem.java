package com.example.start.object.abstracts;

import android.net.Uri;

public abstract class AbsWDItem {

    private String mTitle;
    private String mRate;
    private Uri mImageUri;
    private String mDataType;

    public AbsWDItem() {
        mTitle = "";
        mRate = "";
        mDataType = "";

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

    public void setImageUri(Uri uri) {
        mImageUri = uri;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getRate() {
       return mRate;
    }

    public Uri getImageUri() {
        return mImageUri;
    }

    @Override
    public String toString() {
        return "AbsWDItem{" +
                "mTitle='" + mTitle + '\'' +
                ", mRate='" + mRate + '\'' +
                ", mImageUri=" + (mImageUri != null ? mImageUri.toString() : "") +
                ", mDataType='" + mDataType + '\'' +
                '}';
    }
}
