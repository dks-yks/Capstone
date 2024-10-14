package com.example.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private int categoryId;
    private String categoryName;
}