package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.models.Article;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArticleEntityMapper {

    ArticleEntityMapper INSTANCE = Mappers.getMapper(ArticleEntityMapper.class);

    Article toArticle(ArticleEntity entity);
    ArticleEntity toArticleEntity(Article article);
}
