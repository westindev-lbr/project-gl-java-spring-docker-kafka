package com.fil.sra.exception;

public class ProductDoesNotExistException extends RuntimeException {
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
