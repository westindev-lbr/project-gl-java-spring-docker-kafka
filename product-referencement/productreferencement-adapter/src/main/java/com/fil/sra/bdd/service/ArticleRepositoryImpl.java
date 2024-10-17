package com.fil.sra.bdd.service;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.mapper.ArticleEntityMapper;
import com.fil.sra.bdd.repository.ArticleJPARepository;
import com.fil.sra.bdd.repository.CategoryJPARepository;
import com.fil.sra.models.Article;
import com.fil.sra.interfaces.IArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleRepositoryImpl implements IArticleRepository {

    private final ArticleJPARepository articleJPARepository;
    private final CategoryJPARepository categoryJPARepository;

    public ArticleRepositoryImpl(ArticleJPARepository articleJPARepository,CategoryJPARepository categoryJPARepository){
        this.articleJPARepository = articleJPARepository;
        this.categoryJPARepository = categoryJPARepository;
    }

    @Override
    public List<Article> getArticlesByCriteria(String subName, List<String> categories,int paginationSize,int pageNumber) {
        List<CategoryEntity> categoryEntities = categories.stream().map(name -> categoryJPARepository.findByName(name).orElse(null)).filter(cat -> cat != null).toList();
        Page<ArticleEntity> articles = articleJPARepository.findByNameContainingAndCategoriesIn(subName, categoryEntities, PageRequest.of(pageNumber,paginationSize));
        return articles.getContent().stream()
                .filter(art -> categoryEntities.stream().map(CategoryEntity::getName).collect(Collectors.toSet())
                        .containsAll(art.getCategories().stream().map(CategoryEntity::getName).collect(Collectors.toSet()))
                )
                .map(art -> ArticleEntityMapper.INSTANCE.toArticle(art)).toList();
    }
}
