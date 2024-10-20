package com.fil.sra.ports;

import java.util.Optional;

import com.fil.sra.models.Category;

public interface ICategoryRepository {
    Optional<Void> addCategory(Category category);
}
