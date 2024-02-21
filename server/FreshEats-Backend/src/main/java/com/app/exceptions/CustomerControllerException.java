package com.app.exceptions;

public class CustomerControllerException extends RuntimeException {

    public CustomerControllerException(String message) {
        super(message);
    }

    public CustomerControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
