package com.fil.sra.ports;

import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.models.Article;
import com.fil.sra.models.Category;

import java.util.List;

public interface IArticleRepository {

    Article getArticle(Integer id);
    Article updateArticle(Article article);
    void deleteArticle(Integer id);
    List<Article> getArticlesByCriteria(String ean, String subName, List<Category> categories, int paginationSize, int pageNumber) throws ResourceNotFoundException;
    Article addArticle(Article article, int quantity);
    Article getArticleByName(String name);
}
