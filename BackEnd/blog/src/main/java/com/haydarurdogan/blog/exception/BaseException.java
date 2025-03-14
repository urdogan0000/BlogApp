package com.haydarurdogan.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.util.List;

@Getter
public abstract class BaseException extends RuntimeException {
    private final ErrorCode errorCode;
    private final HttpStatus status;
    private final List<Object> params;

    protected BaseException(ErrorCode errorCode, HttpStatus status, List<Object> params) {
        super(errorCode.name());
        this.errorCode = errorCode;
        this.status = status;
        this.params = params;
    }

    protected BaseException(ErrorCode errorCode, HttpStatus status) {
        this(errorCode, status, null);
    }

}
