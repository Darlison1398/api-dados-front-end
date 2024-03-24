package com.example.drsilva.exception;

public class FrontServiceException extends RuntimeException  {
    public FrontServiceException(String message) {
        super(message);
    }

    public FrontServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
