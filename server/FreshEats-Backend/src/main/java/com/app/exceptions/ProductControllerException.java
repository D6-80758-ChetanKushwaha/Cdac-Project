package com.app.exceptions;

public class ProductControllerException extends RuntimeException {

    public ProductControllerException(String message) {
        super(message);
    }

    public ProductControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
