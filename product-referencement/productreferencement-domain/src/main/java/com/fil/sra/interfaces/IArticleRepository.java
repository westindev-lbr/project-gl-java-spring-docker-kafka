package com.fil.sra.interfaces;

import com.fil.sra.models.Article;

import java.util.List;

public interface IArticleRepository {
    List<Article> getArticlesByCriteria(String subName, List<String> categories,int paginationSize,int pageNumber);
}
