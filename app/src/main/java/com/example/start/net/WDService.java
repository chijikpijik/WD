package com.example.start.net;

import com.squareup.picasso.Downloader;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;

/**
 * Created by akarpov on 6/8/14.
 */
public interface WDService {
    @GET("/")
    void getBody(Callback<Response> callback);
}
