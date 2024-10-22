package com.fil.sra.bdd.repository;

import com.fil.sra.model.MarketOperation;
import com.fil.sra.repository.MarketOperationRepository;

import java.util.List;

public class MarketOperationRepositoryImpl implements MarketOperationRepository {

    protected MarketOperationJPARepository marketOperationJPARepository;

    public List<MarketOperation> addOperation() {
        return List.of();
    }

}
