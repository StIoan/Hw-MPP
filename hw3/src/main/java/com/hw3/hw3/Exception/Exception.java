package com.hw3.hw3.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class Exception extends RuntimeException {
    public Exception(String message) {
        super(message);
    }

    public Exception(String message, Throwable throwable) {
        super(message, throwable);
    }
}
