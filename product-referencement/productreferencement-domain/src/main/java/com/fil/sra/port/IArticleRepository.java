package com.fil.sra.port;

import com.fil.sra.exception.CategoryNotFoundException;
import com.fil.sra.models.Article;

import java.util.List;

public interface IArticleRepository {

    Article getArticle(Integer id);
    Article createArticle(Article article);
    Article updateArticle(Article article);
    void deleteArticle(Integer articleId);

    List<Article> getArticlesByCriteria(String ean,String subName, List<String> categories,int paginationSize,int pageNumber) throws CategoryNotFoundException;
}
