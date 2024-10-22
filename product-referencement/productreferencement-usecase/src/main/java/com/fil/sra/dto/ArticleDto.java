package com.fil.sra.dto;

import com.fil.sra.models.Category;

import java.util.List;

public record ArticleDto(
    int id,
    String name,
    List<Category> categories,
    double price,
    int quantity) {
}
