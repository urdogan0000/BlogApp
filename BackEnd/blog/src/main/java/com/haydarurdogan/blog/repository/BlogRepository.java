package com.haydarurdogan.blog.repository;


import com.haydarurdogan.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {
}
