package com.haydarurdogan.blog.dto;

import lombok.Data;

@Data
public class PaginationRequestDto {

    private int page = 0;   // Default page is 0
    private int size = 10;  // Default size is 10
    private String sortBy = "createdAt";
    private String direction = "ASC";
}
