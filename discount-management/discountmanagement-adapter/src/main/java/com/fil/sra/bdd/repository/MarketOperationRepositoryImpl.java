package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.MarketOperationEntity;
import com.fil.sra.bdd.mapper.MapperEntityToModelVV;
import com.fil.sra.model.MarketOperation;
import com.fil.sra.repository.MarketOperationRepository;

import java.util.List;

public class MarketOperationRepositoryImpl implements MarketOperationRepository {

    protected MarketOperationJPARepository marketOperationJPARepository;

    protected MapperEntityToModelVV mapperEntityToModelVV;

    public MarketOperation addOperation(MarketOperation marketOperation) {
        MarketOperationEntity entity = marketOperationJPARepository.save(mapperEntityToModelVV.toMarketOperationEntity(marketOperation));
        return marketOperation;
    }

}
