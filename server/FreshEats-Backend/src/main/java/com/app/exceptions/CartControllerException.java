package com.app.exceptions;

public class CartControllerException extends RuntimeException {
    public CartControllerException(String message) {
        super(message);

    }

    public CartControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
