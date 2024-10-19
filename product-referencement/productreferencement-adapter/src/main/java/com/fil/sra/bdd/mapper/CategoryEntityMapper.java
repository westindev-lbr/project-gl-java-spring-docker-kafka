package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryEntityMapper {

    // Mapper instance to be used in the application
    CategoryEntityMapper INSTANCE = Mappers.getMapper(CategoryEntityMapper.class);

    Category toCategory(CategoryEntity entity);
    CategoryEntity toCategoryEntity(Category category);

}
