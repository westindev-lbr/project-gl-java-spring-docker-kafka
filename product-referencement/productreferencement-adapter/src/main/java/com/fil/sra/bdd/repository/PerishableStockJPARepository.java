package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.PerishableStockEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerishableStockJPARepository extends CrudRepository<PerishableStockEntity,Integer> {
    Optional<PerishableStockEntity> findByPerishableId(Integer id);
}
