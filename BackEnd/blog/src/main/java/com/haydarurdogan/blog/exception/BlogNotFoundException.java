package com.haydarurdogan.blog.exception;

import org.springframework.http.HttpStatus;
import java.util.Collections;

public class BlogNotFoundException extends BaseException {
    public BlogNotFoundException(String blogId) {
        super(ErrorCode.BLOG_NOT_FOUND, HttpStatus.NOT_FOUND, Collections.singletonList(blogId));
    }
}
