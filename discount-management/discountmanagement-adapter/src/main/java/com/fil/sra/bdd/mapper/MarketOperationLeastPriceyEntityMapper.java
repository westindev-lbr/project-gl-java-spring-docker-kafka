package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.MarketOperationDefaultEntity;
import com.fil.sra.bdd.entity.MarketOperationLeastPriceyEntity;
import com.fil.sra.model.MarketOperationDefault;
import com.fil.sra.model.MarketOperationLeastPricey;

public interface MarketOperationLeastPriceyEntityMapper {

    MarketOperationLeastPriceyEntity toMarketOperationLeastPricey(MarketOperationLeastPricey marketOperationLeastPricey);

    MarketOperationLeastPricey toMarketOperationLeastPriceyEntity(MarketOperationLeastPriceyEntity marketOperationLeastPriceyEntity);

}
