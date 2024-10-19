package com.fil.sra.ports;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.ResearchArticleRequestDto;

import java.util.List;

public interface IArticleUseCases {
    public List<ArticleDto> getPaginatedArticles(ResearchArticleRequestDto search);
}
