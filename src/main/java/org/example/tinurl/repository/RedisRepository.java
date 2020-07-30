package org.example.tinurl.repository;

import org.example.tinurl.model.Url;

public interface RedisRepository {
    String getOriginalUrlByShortUrl(String shortUrl);
    String getShortUrlByOriginalUrl(String originalUrl);
    void add(Url url);
    long generateId();
}
