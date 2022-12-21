package com.elbar.cv_gen.exception.exception;

public class AlreadyCreatedException extends RuntimeException {
    public AlreadyCreatedException() {
    }

    public AlreadyCreatedException(String message) {
        super(message);
    }
}
