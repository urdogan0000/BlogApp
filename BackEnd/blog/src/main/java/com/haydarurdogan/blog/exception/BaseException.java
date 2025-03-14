package com.haydarurdogan.blog.exception;

import org.springframework.http.HttpStatus;
import java.util.List;

public abstract class BaseException extends RuntimeException {
    private final ErrorCode errorCode;
    private final HttpStatus status;
    private final List<Object> params;  // Dynamic params for i18n placeholders

    protected BaseException(ErrorCode errorCode, HttpStatus status, List<Object> params) {
        super(errorCode.name());
        this.errorCode = errorCode;
        this.status = status;
        this.params = params;
    }

    protected BaseException(ErrorCode errorCode, HttpStatus status) {
        this(errorCode, status, null);
    }

    public ErrorCode getErrorCode() { return errorCode; }
    public HttpStatus getStatus() { return status; }
    public List<Object> getParams() { return params; }
}
