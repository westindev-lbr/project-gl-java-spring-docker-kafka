package com.fil.sra.dto;

import com.fil.sra.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArticleDto {
    private int id;
    private String name;
    private List<Category> categories;
    private double price;

}
