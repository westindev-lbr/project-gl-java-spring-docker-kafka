package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.models.Article;
import com.fil.sra.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleJPARepository extends CrudRepository<ArticleEntity,Integer> {
    Page<ArticleEntity> findByNameContainingAndCategories(String subName, List<CategoryEntity> categories, Pageable pageable);

}
