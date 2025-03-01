package com.haydarurdogan.blog.exception;

import java.util.UUID;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(UUID blogId) {
        super("Blog with ID " + blogId + " not found");
    }
}
