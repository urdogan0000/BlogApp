package com.haydarurdogan.blog.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    BLOG_NOT_FOUND(15, "error.blog.notFound"),
    NOT_FOUND(17, "error.notFound"),
    BLOG_ALREADY_EXISTS(16, "error.blog.alreadyExists"),
    BAD_REQUEST(10, "error.badRequest"),
    INTERNAL_SERVER_ERROR(50, "error.internalServerError");

    private final int code;
    private final String messageKey;

    ErrorCode(int code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }


}
