package com.example.forex.exchange.service;

import com.example.forex.exchange.client.FreeForexClient;
import com.example.forex.exchange.client.FreeForexResponse;
import com.example.forex.exchange.exception.InvalidPairException;
import com.example.forex.exchange.model.ExchangeRateResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class ExchangeRateService {

    private final FreeForexClient freeForexClient;

    public ExchangeRateService(FreeForexClient freeForexClient) {
        this.freeForexClient = freeForexClient;
    }

    public ExchangeRateResponse getExchangeRate(String source, String destination) {

        source = source.toUpperCase();
        destination = destination.toUpperCase();

        if (source.equals(destination)) {
            throw new InvalidPairException("source and destination currencies cannot be the same");
        }

        String pair = source + destination;

        FreeForexResponse response = freeForexClient.fetchRate(pair);

        if (response == null || response.rates() == null || !response.rates().containsKey(pair)) {
            throw new InvalidPairException("Invalid currency pair: " + pair);
        }

        FreeForexResponse.RateData data = response.rates().get(pair);

        return new ExchangeRateResponse(
                BigDecimal.valueOf(data.rate()),
                Instant.ofEpochSecond(data.timestamp())
        );
    }
}
