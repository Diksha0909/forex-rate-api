package com.example.forex.exchange.client;
//import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.forex.exchange.exception.ExternalApiException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class FreeForexClient {

    private final RestClient restClient;
    //private final ObjectMapper objectMapper;

    public FreeForexClient(RestClient freeForexRestClient) {
        this.restClient = freeForexRestClient;
    }
//    public FreeForexClient(RestClient freeForexRestClient, ObjectMapper objectMapper) {
//        this.restClient = freeForexRestClient;
//        this.objectMapper = objectMapper;
//    }

    public FreeForexResponse fetchRate(String pair) {
        try {
            return restClient.get()
                    .uri("/api/live?pairs={pairs}", pair)
                    .accept(MediaType.valueOf(MediaType.TEXT_HTML_VALUE))
                    .retrieve()
                    .body(FreeForexResponse.class);
        } catch (Exception ex) {
            throw new ExternalApiException("Failed to fetch exchange rate from external API", ex);
        }
    }
//public String fetchRateRaw(String pair) {
//    return restClient.get()
//            .uri("/api/live?pairs={pairs}", pair)
//            .retrieve()
//            .body(String.class);
//}
//
//    public FreeForexResponse fetchRate(String pair) {
//        try {
//            String raw = fetchRateRaw(pair);
//            return objectMapper.readValue(raw, FreeForexResponse.class);
//        } catch (Exception ex) {
//            throw new ExternalApiException("Invalid response from external API", ex);
//        }
//    }

}

