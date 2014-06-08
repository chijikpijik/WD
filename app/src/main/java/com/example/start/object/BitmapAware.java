package com.example.start.object;

import android.graphics.Bitmap;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: ANDDEV
 * Date: 19.03.14
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class BitmapAware {

    private Bitmap mImage;
    private URI mBitmapUri;

    public Bitmap getImage() {
        return mImage;
    }

    public URI getBitmapUri() {
        return mBitmapUri;
    }

    public void setImage(Bitmap mImage) {
        this.mImage = mImage;
    }

    public void setBitmapUri(URI mBitmapUri) {
        this.mBitmapUri = mBitmapUri;
    }

    @Override
    public boolean equals(Object o) {
        return getBitmapUri().equals(((BitmapAware)o).getBitmapUri());
    }
}

