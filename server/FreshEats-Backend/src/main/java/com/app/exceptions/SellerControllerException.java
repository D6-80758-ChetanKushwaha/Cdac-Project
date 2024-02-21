package com.app.exceptions;

public class SellerControllerException extends RuntimeException {

    public SellerControllerException(String message) {
        super(message);
    }

    public SellerControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
