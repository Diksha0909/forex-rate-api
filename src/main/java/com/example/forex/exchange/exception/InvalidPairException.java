package com.example.forex.exchange.exception;

public class InvalidPairException extends RuntimeException {
    public InvalidPairException(String message) {
        super(message);
    }
}
