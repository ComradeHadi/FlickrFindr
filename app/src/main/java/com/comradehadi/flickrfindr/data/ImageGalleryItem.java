package com.comradehadi.flickrfindr.data;

import java.io.Serializable;

public class ImageGalleryItem implements Serializable {

    private String id;
    private String secret;
    private String server;
    private String farm;

    public ImageGalleryItem(String id, String secret, String server, String farm) {
        this.id = id;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return "http://farm" + farm + ".static.flickr.com/" + server + "/" + id + "_" + secret + ".jpg";
    }
}
