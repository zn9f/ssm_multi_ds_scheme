package com.jetora.common.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4880328265878141724L;
    public ResourceNotFoundException() {
        super();
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}