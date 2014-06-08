package com.example.start.net;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class Request {

    public HttpRequestBase getHttpRequest() throws Exception {
        HttpRequestBase request = new HttpGet(getUri());
        return request;
    }
    public abstract URI getUri() throws Exception;

    public HttpClient getHttpClient() {
        HttpClient client = new DefaultHttpClient();
        return client;
    }

    public void execute() throws Exception {
        HttpResponse response = getHttpClient().execute(getHttpRequest());
        processHttpResponse(response);
    }

    private void processHttpResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
//        String s = null;
//        try {
//            s = EntityUtils.toString(entity);
//        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
        InputStream responseStream = null;
        try {
            responseStream = entity.getContent();
            parse(responseStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void parse(InputStream input);

}
