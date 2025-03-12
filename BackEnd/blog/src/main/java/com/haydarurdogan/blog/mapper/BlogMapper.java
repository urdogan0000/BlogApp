package com.haydarurdogan.blog.mapper;

import com.haydarurdogan.blog.dto.BlogRequestDto;
import com.haydarurdogan.blog.entity.Blog;

public class BlogMapper {

    // Convert BlogRequestDto to Blog entity
    public static Blog toEntity(BlogRequestDto blogRequestDto) {
        Blog blog = new Blog();
        // Map fields directly
        blog.setOwnerId(blogRequestDto.getOwnerId());
        blog.setTitle(blogRequestDto.getTitle());
        blog.setDescription(blogRequestDto.getDescription());
        blog.setCreatedAt(blogRequestDto.getCreatedAt());
        blog.setUpdatedAt(blogRequestDto.getCreatedAt());

        // Return the entity
        return blog;
    }

    // Update existing Blog entity with BlogRequestDto fields
    public static Blog updateEntity(Blog existingBlog, BlogRequestDto blogRequestDto) {
        if (blogRequestDto.getTitle() != null) {
            existingBlog.setTitle(blogRequestDto.getTitle());
        }

        // Always set the description, even if it's null
        existingBlog.setDescription(blogRequestDto.getDescription());

        return existingBlog;
    }
}
