package com.fil.sra.repository;

import com.fil.sra.models.Article;
import com.fil.sra.models.Category;

import java.util.List;

public interface IArticleRepository {
    List<Article> getArticlesByCriteria(String subName, List<String> categories,int paginationSize,int pageNumber);
}
