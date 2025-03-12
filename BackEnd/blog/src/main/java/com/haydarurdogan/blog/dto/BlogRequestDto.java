package com.haydarurdogan.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDto {
    @NotEmpty(message = "Title cannot be empty")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    private String description;

    private UUID ownerId;

    private Date createdAt=new Date();
}

