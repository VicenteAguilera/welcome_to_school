package com.github.sistemas_tecnm_uruapan.helpers.flipper;

@SuppressWarnings("unused")
public class OperationFailedException extends RuntimeException {
    public OperationFailedException() {
        super();
    }

    public OperationFailedException(String message) {
        super(message);
    }

    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationFailedException(Throwable cause) {
        super(cause);
    }
}