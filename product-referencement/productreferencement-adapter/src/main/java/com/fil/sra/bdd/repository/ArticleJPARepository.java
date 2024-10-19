package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleJPARepository extends PagingAndSortingRepository<ArticleEntity,Integer> {
    Page<ArticleEntity> findByNameContainingAndCategoriesIn(String subName, List<CategoryEntity> categories, Pageable pageable);
    Optional<ArticleEntity> findById(Integer id);

}
