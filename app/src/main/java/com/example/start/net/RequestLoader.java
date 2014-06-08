package com.example.start.net;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class RequestLoader extends AsyncTaskLoader<Request> {

    private Request mRequest;

    public RequestLoader(Context context) {
        super(context);
    }

    public void setRequest(Request request) {
        mRequest = request;
    }

    @Override
    public Request loadInBackground() {
        try {
            mRequest.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mRequest;
    }
}
