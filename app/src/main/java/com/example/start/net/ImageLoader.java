package com.example.start.net;

import android.content.Context;

public class ImageLoader extends RequestLoader{

    public ImageLoader(Context context, Request request) {
        super(context);
        setRequest(request);
    }


}
