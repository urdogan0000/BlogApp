package com.haydarurdogan.blog.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;

public class NotFoundException extends BaseException{
    public NotFoundException(String message) {
        super(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND,  Collections.singletonList(null) );
    }
}
