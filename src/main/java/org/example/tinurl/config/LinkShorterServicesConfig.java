package org.example.tinurl.config;

import org.example.tinurl.backend.BaseN;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LinkShorterServicesConfig {

    @Bean
    public BaseN base63() {
        char[] charsOfBase63 = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_'
        };
        return new BaseN(charsOfBase63, 10);
    }

    @Bean
    public Long maxIdValue(BaseN base63) {
        return base63.getMaxLongValueInBase10();
    }
}
