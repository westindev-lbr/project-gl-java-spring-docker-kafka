package com.fil.sra.services;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.interfaces.IArticleRepository;
import com.fil.sra.mapper.ArticleDtoMapper;
import com.fil.sra.models.Article;
import com.fil.sra.ports.IArticleUseCases;

import java.util.List;

public class ArticleUseCasesImpl implements IArticleUseCases {
    private final IArticleRepository articleRepository;

    public ArticleUseCasesImpl(IArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleDto> getPaginatedArticles(ResearchArticleRequestDto search) {
        List<Article> articles = articleRepository.getArticlesByCriteria(search.getSubName(),search.getCategories(),search.getPaginationSize(),search.getPageNumber());
        return articles.stream().map(article -> ArticleDtoMapper.INSTANCE.toArticleDto(article)).toList();
    }
}
