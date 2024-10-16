package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.models.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleEntityMapper {

    // Mapper instance to be used in the application
    ArticleEntityMapper INSTANCE = Mappers.getMapper(ArticleEntityMapper.class);

    // Mapping between ArticleEntity and Article (model)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "ean", target = "ean")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "vat", target = "vat")
    @Mapping(source = "img", target = "img")
    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "name", target = "name")
    Article toArticle(ArticleEntity entity);

    // Inverse Mapping
    @Mapping(source = "id", target = "id")
    @Mapping(source = "ean", target = "ean")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "vat", target = "vat")
    @Mapping(source = "img", target = "img")
    @Mapping(source = "categories", target = "categories") // Assuming CategoryEntity is mapped similarly
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "name", target = "name")
    ArticleEntity toArticleEntity(Article article);
}
