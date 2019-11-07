package com.comradehadi.flickrfindr.utils;

import android.net.Uri;

import com.comradehadi.flickrfindr.BuildConfig;


public class ServerRequestHandler {
    private static final String TAG = ServerRequestHandler.class.getSimpleName();

    public static final String PREF_SEARCH_QUERY ="searchQuery";

    private static final String ENDPOINT = "https://api.flickr.com/services/rest/";
    private static final String METHOD_GETRECENT = "flickr.photos.getRecent";
    private static final String METHOD_SEARCH = "flickr.photos.search";

    private static volatile ServerRequestHandler instance = null;
    private ServerRequestHandler() {

    }

    public static ServerRequestHandler getInstance() {
        if (instance == null) {
            synchronized (ServerRequestHandler.class) {
                if (instance == null) {
                    instance = new ServerRequestHandler();
                }
            }
        }
        return instance;
    }

    public static String getImageUrl(String query) {
        String url;
        if (query != null) {
            url = Uri.parse(ENDPOINT).buildUpon()
                    .appendQueryParameter("method", METHOD_SEARCH)
                    .appendQueryParameter("api_key", BuildConfig.API_KEY)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("text", query)
                    .appendQueryParameter("page", "25")
                    .build().toString();
        } else {
            url = Uri.parse(ENDPOINT).buildUpon()
                    .appendQueryParameter("method", METHOD_GETRECENT)
                    .appendQueryParameter("api_key", BuildConfig.API_KEY)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("page", "25")
                    .build().toString();
        }
        return url;
    }
}
