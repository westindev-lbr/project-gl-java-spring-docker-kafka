package com.fil.sra.bdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fil.sra.bdd.entity.StockEntity;


@Repository
public interface StockJPARepository extends CrudRepository<StockEntity,Integer> {
    StockEntity findById(int id);
    StockEntity findByArticleId(int articleId);
    <S extends StockEntity> S save(S stockEntity);
}
