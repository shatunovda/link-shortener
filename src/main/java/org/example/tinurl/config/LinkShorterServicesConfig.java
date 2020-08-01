package org.example.tinurl.config;

import org.example.tinurl.backend.Base63;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LinkShorterServicesConfig {

    @Bean
    public Long maxIdValue(){
        return Base63.MAX_LONG_VALUE_FOR_BASE_63;
    }
}
