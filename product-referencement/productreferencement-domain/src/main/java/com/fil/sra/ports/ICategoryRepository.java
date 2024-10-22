package com.fil.sra.ports;

import com.fil.sra.models.Category;

public interface ICategoryRepository {
    Category addCategory(Category category);
}
