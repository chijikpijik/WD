package com.example.start.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ImageView;
import com.example.start.CACHE;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: ANDDEV
 * Date: 11.03.14
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class ImageAssigner implements LoaderManager.LoaderCallbacks<Request> {

    private Context mContext;
    private int mLoaderId;
    private URI mImageURI;
    private ImageView mImageView;

    public ImageAssigner(Context context, URI imageUri, ImageView view, int loaderId) {
        mContext = context;
        mLoaderId = loaderId;
        mImageView = view;
        mImageURI = imageUri;
    }

    public void assign() {
        if (CACHE.INSTANCE.getCache().get(mImageURI.getRawQuery()) != null)
            setBitmap((Bitmap)
                    CACHE.INSTANCE.getCache().get(mImageURI.getRawPath()));
        else
            ((FragmentActivity)mContext)
                    .getSupportLoaderManager().restartLoader(mLoaderId, null, this);
    }

    private void setBitmap(Bitmap bmp) {
        mImageView.setImageBitmap(bmp);
    }

    private ImageView getView() {
        return mImageView;
    }

    @Override
    public Loader<Request> onCreateLoader(int i, Bundle bundle) {
        GetImage request = new GetImage();
        request.setUri(mImageURI);
        return new ImageLoader(mContext, request);
    }

    @Override
    public void onLoadFinished(Loader<Request> requestLoader, Request request) {
        Bitmap img = ((GetImage)request).getBitmap();
        setBitmap(img);
    }

    @Override
    public void onLoaderReset(Loader<Request> loader) {
    }
}
