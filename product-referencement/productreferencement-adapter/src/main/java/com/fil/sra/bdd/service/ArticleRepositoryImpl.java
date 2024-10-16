package com.fil.sra.bdd.service;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.mapper.ArticleEntityMapper;
import com.fil.sra.bdd.repository.ArticleJPARepository;
import com.fil.sra.bdd.repository.CategoryJPARepository;
import com.fil.sra.models.Article;
import com.fil.sra.interfaces.IArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleRepositoryImpl implements IArticleRepository {
    @Autowired
    private ArticleJPARepository articleJPARepository;
    @Autowired
    private CategoryJPARepository categoryJPARepository;
    @Override
    public List<Article> getArticlesByCriteria(String subName, List<String> categories,int paginationSize,int pageNumber) {
        List<CategoryEntity> categoryEntities = categories.stream().map(name -> categoryJPARepository.findByName(name)).toList();
        List<ArticleEntity> articles = articleJPARepository.findByNameContainingAndCategories(subName, categoryEntities);
        return articles.stream().map(art -> ArticleEntityMapper.INSTANCE.toArticle(art)).toList();
    }
}
