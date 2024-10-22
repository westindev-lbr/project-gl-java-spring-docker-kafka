package com.fil.sra.bdd.repository;

import com.fil.sra.model.MarketOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketOperationJPARepository extends CrudRepository<MarketOperation, Integer> {
}
