package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryEntityMapper {

    // Mapper instance to be used in the application
    CategoryEntityMapper INSTANCE = Mappers.getMapper(CategoryEntityMapper.class);

    Category toCategory(CategoryEntity entity);
    CategoryEntity toCategoryEntity(Category category);

}
