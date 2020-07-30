package org.example.tinurl.model;

import java.io.Serializable;

public class Url implements Serializable {

    private static final long serialVersionUID = 8218717950503696843L;
    private String shortUrl;
    private String originUrl;

    public Url(String shortUrl, String originUrl) {
        this.shortUrl = shortUrl;
        this.originUrl = originUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "shortUrl='" + shortUrl + '\'' +
                ", originUrl='" + originUrl + '\'' +
                '}';
    }
}
