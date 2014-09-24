package com.example.start.object.abstracts;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsWDItem {

    private String mTitle;
    private String mRate;
    private Uri mSmallImageUri;
    private Uri mImageUri;
    private String mDataType;
    private List<String> mHashTags;

    public AbsWDItem() {
        mTitle = "";
        mRate = "";
        mDataType = "";
        mHashTags = new ArrayList<String>();
    }

    public void addHashTags(String hashTag) {
        mHashTags.add(hashTag);
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

    public void setSmallImageUri(Uri uri) {
        mSmallImageUri = uri;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getRate() {
       return mRate;
    }

    public Uri getSmallImageUri() {
        return mSmallImageUri;
    }

    public Uri getImageUri() {
        return mImageUri;
    }

    public List<String> getHashTags() {
        return mHashTags;
    }

    public String toStringHashTags() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String hashTag : mHashTags) {
            stringBuilder.append(" " + hashTag);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {

        return "AbsWDItem{" +
                "mTitle='" + mTitle + '\'' +
                ", mRate='" + mRate + '\'' +
                ", mSmallImageUri=" + (mSmallImageUri != null ? mSmallImageUri.toString() : "") +
                ", mDataType='" + mDataType + '\'' +
                ", mImageUri='" + mImageUri + '\'' +
                ", mHasTags='" + toStringHashTags() + '\'' +
                '}';
    }
}
