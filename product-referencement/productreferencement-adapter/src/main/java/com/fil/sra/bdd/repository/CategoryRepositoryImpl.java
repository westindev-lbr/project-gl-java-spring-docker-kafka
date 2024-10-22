package com.fil.sra.bdd.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.mapper.CategoryEntityMapper;
import com.fil.sra.models.Category;
import com.fil.sra.ports.ICategoryRepository;

@Component
public class CategoryRepositoryImpl implements ICategoryRepository {

    private final CategoryJPARepository categoryJPARepository;
    private final CategoryEntityMapper categoryEntityMapper;


    public CategoryRepositoryImpl(CategoryJPARepository categoryJPARepository, CategoryEntityMapper categoryEntityMapper) {
        this.categoryJPARepository = categoryJPARepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public Optional<Void> addCategory(Category category) {
        CategoryEntity categoryEntity = categoryEntityMapper.toCategoryEntity(category);
        categoryJPARepository.save(categoryEntity);
        return Optional.empty();
    }

}
