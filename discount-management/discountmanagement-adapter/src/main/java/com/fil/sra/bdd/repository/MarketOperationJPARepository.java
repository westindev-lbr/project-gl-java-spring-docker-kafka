package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.MarketOperationEntity;
import com.fil.sra.model.MarketOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketOperationJPARepository extends CrudRepository<MarketOperationEntity, Integer> {
}
