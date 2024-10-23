package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.MarketOperationDefaultEntity;
import com.fil.sra.model.MarketOperationDefault;
import org.mapstruct.Mapper;

@Mapper
public interface MarketOperationDefaultEntityMapper {

    MarketOperationDefaultEntity toMarketOperationDefault(MarketOperationDefault marketOperationDefault);

    MarketOperationDefault toMarketOperationDefaultEntity(MarketOperationDefaultEntity marketOperationDefaultEntity);
}
