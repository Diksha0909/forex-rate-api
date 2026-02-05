package com.example.forex.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpClientConfig {

    @Bean
        public RestClient freeForexRestClient() {
            return RestClient.builder()
                    .baseUrl("https://www.freeforexapi.com")
                    .build();
        }


}
