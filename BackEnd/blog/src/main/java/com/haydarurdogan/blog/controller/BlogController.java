package com.haydarurdogan.blog.controller;

import com.haydarurdogan.blog.dto.BlogRequestDto;
import com.haydarurdogan.blog.dto.PaginationRequestDto;
import com.haydarurdogan.blog.entity.Blog;
import com.haydarurdogan.blog.mapper.BlogMapper;
import com.haydarurdogan.blog.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    // Get all blogs with pagination
    @GetMapping
    public ResponseEntity<Page<Blog>> getAllBlogs(PaginationRequestDto paginationRequestDto) {
        Pageable pageable = toPageable(paginationRequestDto);  // Convert DTO to Pageable
        Page<Blog> blogs = blogService.getAllBlogs(pageable);

        if (blogs.isEmpty()) {
            return ResponseEntity.noContent().build();  // 204 No Content if no blogs
        }

        return ResponseEntity.ok(blogs);  // 200 OK with the list of blogs
    }

    // Create a new blog using BlogRequestDto and BlogMapper
    @PostMapping
    public ResponseEntity<Blog> createBlog(@Valid @RequestBody BlogRequestDto blogRequestDto) {
        Blog blog = BlogMapper.toEntity(blogRequestDto);  // Map DTO to Entity
        Blog savedBlog = blogService.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBlog);  // 201 Created
    }

    // Update an existing blog using BlogRequestDto and BlogMapper
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable UUID id, @Valid @RequestBody BlogRequestDto blogRequestDto) {
        Blog existingBlog = blogService.findBlogById(id);  // Fetch existing blog
        Blog updatedBlog = BlogMapper.updateEntity(existingBlog, blogRequestDto);  // Update entity with new data
        Blog savedBlog = blogService.save(updatedBlog);  // Save updated blog
        return ResponseEntity.ok(savedBlog);  // 200 OK with updated blog
    }

    // Delete a blog by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable UUID id) {
        blogService.deleteBlog(id);  // Delete the blog
        return ResponseEntity.noContent().build();  // 204 No Content if deletion is successful
    }

    // Helper method to convert PaginationRequestDto to Pageable
    private Pageable toPageable(PaginationRequestDto paginationRequestDto) {
        return PageRequest.of(paginationRequestDto.getPage(), paginationRequestDto.getSize());
    }
}
