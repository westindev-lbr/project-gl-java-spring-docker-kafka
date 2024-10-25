package com.fil.sra.ports;

import com.fil.sra.models.Category;

import java.util.List;

public interface ICategoryRepository {
    Category addCategory(Category category);
    Category getCategoryByName(String name);
    List<Category> getAllCategoryByNames(List<String> names);

}
