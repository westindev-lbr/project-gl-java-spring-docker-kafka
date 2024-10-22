package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.*;
import com.fil.sra.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ObjectFactory;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperEntityToModelVV {

    @SubclassMapping(source = MarketOperationDefaultEntity.class, target = MarketOperationDefault.class)
    @SubclassMapping(source = MarketOperationCodeEntity.class, target = MarketOperationCode.class)
    @SubclassMapping(source = MarketOperationLeastPriceyEntity.class, target = MarketOperationLeastPricey.class)
    @SubclassMapping(source = MarketOperationLotEntity.class, target = MarketOperationLot.class)
    @SubclassMapping(source = MarketOperationOneFreeEntity.class, target = MarketOperationOneFree.class)
    MarketOperation toMarketOperation(MarketOperationEntity marketOperationEntity);

    @SubclassMapping(source = MarketOperationDefault.class, target = MarketOperationDefaultEntity.class)
    @SubclassMapping(source = MarketOperationCode.class, target = MarketOperationCodeEntity.class)
    @SubclassMapping(source = MarketOperationLeastPricey.class, target = MarketOperationLeastPriceyEntity.class)
    @SubclassMapping(source = MarketOperationLot.class, target = MarketOperationLotEntity.class)
    @SubclassMapping(source = MarketOperationOneFree.class, target = MarketOperationOneFreeEntity.class)
    MarketOperationEntity toMarketOperationEntity(MarketOperation marketOperation);
}
