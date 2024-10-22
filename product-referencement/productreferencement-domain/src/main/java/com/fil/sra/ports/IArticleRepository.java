package com.fil.sra.ports;

import com.fil.sra.models.Article;

import java.util.List;

public interface IArticleRepository {
    List<Article> getArticlesByCriteria(Integer articleId,String subName, List<String> categories,int paginationSize,int pageNumber);
    Article addArticle(Article article);
}
