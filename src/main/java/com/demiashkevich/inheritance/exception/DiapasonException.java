package com.demiashkevich.inheritance.exception;

public class DiapasonException extends Exception {

    public DiapasonException(String message) {
        super(message);
    }

    public DiapasonException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiapasonException() {
        super();
    }
}
