package com.fil.sra.mapper;

import com.fil.sra.dto.ArticleCommand;
import com.fil.sra.models.Article;
import com.fil.sra.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ArticleCommandMapper {

    ArticleCommandMapper INSTANCE = Mappers.getMapper(ArticleCommandMapper.class);

    @Mapping(target = "categories", source = "processedCategories")
    Article toArticle(ArticleCommand articleCommand, List<Category> processedCategories);

    @Mapping(target = "categories", expression = "java(mapCategoryNames(article.getCategories()))")
    ArticleCommand toArticleCommand(Article article);

    // Méthode par défaut pour transformer une liste de Category en une liste de noms de catégories
    default List<String> mapCategoryNames(List<Category> categories) {
        return categories != null ? categories.stream()
                .map(Category::getName)
                .toList() : new ArrayList<>();
    }
}

