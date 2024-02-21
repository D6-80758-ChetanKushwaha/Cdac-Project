package com.app.exceptions;

public class CatrgoryControllerException extends RuntimeException {
    
    public CatrgoryControllerException(String message){
        super(message);
    }
    public CatrgoryControllerException(String message, Throwable cause){
        super(message,cause);
    }
}
