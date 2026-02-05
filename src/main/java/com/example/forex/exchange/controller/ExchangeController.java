package com.example.forex.exchange.controller;

import com.example.forex.exchange.model.ExchangeRateRequest;
import com.example.forex.exchange.model.ExchangeRateResponse;
import com.example.forex.exchange.service.ExchangeRateService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchange-rate")
public class ExchangeController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ExchangeRateResponse getRate(@Valid @RequestBody ExchangeRateRequest request) {
            return exchangeRateService.getExchangeRate(request.source(), request.destination());
        }


}
