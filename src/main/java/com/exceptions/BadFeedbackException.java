package com.exceptions;

public class BadFeedbackException extends RuntimeException {
    public BadFeedbackException(String message) {
        super(message);
    }
}
