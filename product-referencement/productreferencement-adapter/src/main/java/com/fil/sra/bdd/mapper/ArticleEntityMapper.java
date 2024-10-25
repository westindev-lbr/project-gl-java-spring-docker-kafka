package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.StockEntity;
import com.fil.sra.models.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArticleEntityMapper {
    ArticleEntityMapper INSTANCE = Mappers.getMapper(ArticleEntityMapper.class);


    @Mapping(target = "stockGlobal", ignore = true)
    Article toArticle(ArticleEntity entity);

    @Mapping(target = "stockGlobal", ignore = true)
    ArticleEntity toArticleEntity(Article article);
}
