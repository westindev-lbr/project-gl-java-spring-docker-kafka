package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.MarketOperationDefaultEntity;
import com.fil.sra.bdd.entity.MarketOperationLotEntity;
import com.fil.sra.model.MarketOperationDefault;
import com.fil.sra.model.MarketOperationLot;
import org.mapstruct.Mapper;

@Mapper
public interface MarketOperationLotEntityMapper {

    MarketOperationLotEntity toMarketOperationOneFree(MarketOperationLot marketOperationLot);

    MarketOperationLot toMarketOperationOneFreeEntity(MarketOperationLotEntity marketOperationLotEntity);

}
