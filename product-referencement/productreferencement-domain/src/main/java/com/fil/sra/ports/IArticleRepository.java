package com.fil.sra.ports;

import com.fil.sra.models.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleRepository {
    List<Article> getArticlesByCriteria(Integer articleId,String subName, List<String> categories,int paginationSize,int pageNumber);
    Optional<Void> addArticle(Article article);
}
