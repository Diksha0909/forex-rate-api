package com.example.forex.exchange.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ExchangeRateRequest(

        @NotBlank(message = "source currency is required")
        @Pattern(regexp = "^[A-Za-z]{3}$", message = "source must be a 3-letter currency code")
        String source,

        @NotBlank(message = "destination currency is required")
        @Pattern(regexp = "^[A-Za-z]{3}$", message = "destination must be a 3-letter currency code")
        String destination
) {}
