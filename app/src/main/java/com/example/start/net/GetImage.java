package com.example.start.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.URI;

import android.net.Uri;

public class GetImage extends Request {
    private URI mUri;
    private Bitmap mBitmap;

    public void setUri(URI uri) {
        mUri = uri;
    }

    @Override
    public URI getUri() throws Exception {
        return mUri;
    }

    @Override
    public void parse(InputStream input) {
        mBitmap = BitmapFactory.decodeStream(input);
    }

    public Bitmap getBitmap() {
         return mBitmap;
    }
}
