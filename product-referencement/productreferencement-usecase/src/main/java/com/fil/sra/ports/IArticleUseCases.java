package com.fil.sra.ports;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.ArticleCommand;
import com.fil.sra.dto.ResearchArticleRequestDto;

import java.util.List;

public interface IArticleUseCases {
    List<ArticleCommand> getPaginatedArticles(ResearchArticleRequestDto search);
    ArticleDto createArticle(ArticleCommand command);
    void deleteArticle(Integer id);

    ArticleDto updateArticle(Integer id,ArticleCommand command);
}
