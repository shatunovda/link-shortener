package org.example.tinurl.config;

import org.example.tinurl.repository.RedisRepository;
import org.example.tinurl.repository.RedisRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

@Configuration
public class AppConfig {

//    @Bean
//    public RedisRepository redisRepository(
//            RedisTemplate<String, Object> redisTemplate,
//            RedisScript<Long> scriptIncrToMax) {
//        return new RedisRepositoryImpl(redisTemplate, scriptIncrToMax, 10L);
//    }

    @Bean
    public Long maxIdValue(){
        return 10L;
    }
}
