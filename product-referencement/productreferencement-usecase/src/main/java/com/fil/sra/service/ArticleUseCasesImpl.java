package com.fil.sra.service;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.ports.IArticleUseCases;

import java.util.List;

public class ArticleUseCasesImpl implements IArticleUseCases {
    @Override
    public List<ArticleDto> getPaginatedArticles(ResearchArticleRequestDto search) {
        return null;
    }
}
