package com.app.exceptions;

public class OrderControllerException extends RuntimeException {

    public OrderControllerException(String message) {
        super(message);
    }

    public OrderControllerException(String message, Throwable cause) {
        super(message, cause);
    }

}