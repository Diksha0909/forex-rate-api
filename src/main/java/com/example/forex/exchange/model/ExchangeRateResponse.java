package com.example.forex.exchange.model;

import java.math.BigDecimal;
import java.time.Instant;

public record ExchangeRateResponse(
        BigDecimal rate,
        Instant updatedAt
) {}
