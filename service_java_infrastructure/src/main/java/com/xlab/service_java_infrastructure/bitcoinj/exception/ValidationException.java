package com.xlab.service_java_infrastructure.bitcoinj.exception;

public class ValidationException extends Exception{

    private static final long serialVersionUID = 1L;

    public ValidationException(Throwable cause) {
        super (cause);
    }

    public ValidationException(String message, Throwable cause) {
        super (message, cause);
    }

    public ValidationException(String message) {
        super (message);
    }
}
