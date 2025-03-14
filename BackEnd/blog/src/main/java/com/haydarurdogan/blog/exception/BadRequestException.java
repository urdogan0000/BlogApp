package com.haydarurdogan.blog.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {
    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }
}