package com.fil.sra.bdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fil.sra.bdd.entity.StockEntity;
import java.util.Optional;


@Repository
public interface StockJPARepository extends CrudRepository<StockEntity,Integer> {
    Optional<StockEntity> findByArticleId(Integer id);
}
