package com.example.forex.common.exception;

public class InvalidPairException extends RuntimeException {
    public InvalidPairException(String message) {
        super(message);
    }
}
