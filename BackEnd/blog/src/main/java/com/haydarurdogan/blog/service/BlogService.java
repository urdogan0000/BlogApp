package com.haydarurdogan.blog.service;

import com.haydarurdogan.blog.entity.Blog;
import com.haydarurdogan.blog.exception.BlogNotFoundException;
import com.haydarurdogan.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);  // Return paginated list of blogs
    }

    @Transactional
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);  // Save new blog
    }

    @Transactional
    public Blog findBlogById(UUID blogId) {
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException(blogId.toString()));

    }

    @Transactional
    public Blog save(Blog blog) {
        return blogRepository.save(blog);  // Save the updated blog
    }

    @Transactional
    public void deleteBlog(UUID blogId) {
        blogRepository.deleteById(blogId);  // Delete blog by ID
    }
}
