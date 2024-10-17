package com.fil.sra.mapper;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.models.Article;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleDtoMapper {
    ArticleDtoMapper INSTANCE = Mappers.getMapper(ArticleDtoMapper.class);

    Article toArticle(ArticleDto dto);
    ArticleDto toArticleDto(Article article);
}
