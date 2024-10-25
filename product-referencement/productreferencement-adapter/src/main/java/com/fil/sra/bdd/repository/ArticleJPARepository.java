package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleJPARepository extends PagingAndSortingRepository<ArticleEntity, Integer>, CrudRepository<ArticleEntity, Integer>, JpaSpecificationExecutor<ArticleEntity> {
    Optional<ArticleEntity> findByName(String name);
}
