package com.fil.sra.ports;

import com.fil.sra.exception.CategoryNotFoundException;
import com.fil.sra.models.Article;

import java.util.List;

public interface IArticleRepository {

    Article getArticle(Integer id);
    Article updateArticle(Article article);
    void deleteArticle(Integer articleId);
    List<Article> getArticlesByCriteria(String ean,String subName, List<String> categories,int paginationSize,int pageNumber) throws CategoryNotFoundException;
    Article addArticle(Article article, int quantity);
}
