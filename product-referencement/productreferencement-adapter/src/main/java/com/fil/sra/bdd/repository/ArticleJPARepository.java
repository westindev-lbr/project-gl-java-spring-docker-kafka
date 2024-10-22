package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleJPARepository extends PagingAndSortingRepository<ArticleEntity,Integer>,CrudRepository<ArticleEntity,Integer> {
    Page<ArticleEntity> findByNameContainingAndCategoriesIn(String subName, List<CategoryEntity> categories, Pageable pageable);
}
