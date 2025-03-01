package com.haydarurdogan.blog.exception;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message) {
        super(message);
    }
}
