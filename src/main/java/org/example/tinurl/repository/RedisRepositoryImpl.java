package org.example.tinurl.repository;

import org.example.tinurl.model.Url;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static java.util.Collections.singletonList;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY_SHORT_TO_ORIGINAL_URL = "short_to_original";
    private static final String KEY_ORIGINAL_TO_SHORT_URL = "original_to_short";
    private static final String KEY_COUNTER = "counter";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    private RedisScript<Long> scriptIncrToMax;
    private Long maxIdValue;

    public RedisRepositoryImpl(
            RedisTemplate<String, Object> redisTemplate,
            RedisScript<Long> scriptIncrToMax,
            Long maxIdValue) {

        this.redisTemplate = redisTemplate;
        this.scriptIncrToMax = scriptIncrToMax;
        this.maxIdValue = maxIdValue;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public String getOriginalUrlByShortUrl(String shortUrl) {
        return (String) hashOperations.get(KEY_SHORT_TO_ORIGINAL_URL, shortUrl);
    }

    @Override
    public String getShortUrlByOriginalUrl(String originalUrl) {
        return (String) hashOperations.get(KEY_ORIGINAL_TO_SHORT_URL, originalUrl);
    }

    @Override
    public void add(Url url) {
        hashOperations.put(KEY_SHORT_TO_ORIGINAL_URL, url.getShortUrl(), url.getOriginUrl());
        hashOperations.put(KEY_ORIGINAL_TO_SHORT_URL, url.getOriginUrl(), url.getShortUrl());
    }

    @Override
    public long generateId() {
        return redisTemplate.execute(scriptIncrToMax, singletonList(KEY_COUNTER), maxIdValue);
    }
}
