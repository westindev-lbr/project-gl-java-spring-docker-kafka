package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.MarketOperationCodeEntity;
import com.fil.sra.model.MarketOperationCode;
import org.mapstruct.Mapper;

@Mapper
public interface MarketOperationCodeEntityMapper {

    MarketOperationCodeEntity toMarketOperationCode(MarketOperationCode marketOperationCode);

    MarketOperationCode toMarketOperationCodeEntity(MarketOperationCodeEntity marketOperationCodeEntity);

}
