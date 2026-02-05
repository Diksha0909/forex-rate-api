package com.example.forex.exchange.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FreeForexResponse(
        Map<String, RateData> rates,
        int code
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record RateData(
            double rate,
            long timestamp
    ) {}
}
