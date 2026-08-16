package com.atm.exception;

public class InvalidHolderNameException extends RuntimeException {
    public InvalidHolderNameException(String message) {
        super(message);
    }
}
