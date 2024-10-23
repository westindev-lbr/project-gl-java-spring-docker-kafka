package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.MarketOperationDefaultEntity;
import com.fil.sra.bdd.entity.MarketOperationOneFreeEntity;
import com.fil.sra.model.MarketOperationDefault;
import com.fil.sra.model.MarketOperationOneFree;

public interface MarketOperationOneFreeEntityMapper {

    MarketOperationOneFreeEntity toMarketOperationOneFree(MarketOperationOneFree marketOperationOneFree);

    MarketOperationOneFree toMarketOperationOneFreeEntity(MarketOperationOneFreeEntity marketOperationOneFreeEntity);

}
