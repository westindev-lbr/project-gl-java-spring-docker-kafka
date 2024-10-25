package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.*;
import com.fil.sra.model.*;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION ,uses = {  })
public interface MapperEntityToModelVV {

    @SubclassMapping(source = MarketOperationDefaultEntity.class, target = MarketOperationDefault.class)
    @SubclassMapping(source = MarketOperationCodeEntity.class, target = MarketOperationCode.class)
    @SubclassMapping(source = MarketOperationLeastPriceyEntity.class, target = MarketOperationLeastPricey.class)
    @SubclassMapping(source = MarketOperationLotEntity.class, target = MarketOperationLot.class)
    @SubclassMapping(source = MarketOperationOneFreeEntity.class, target = MarketOperationOneFree.class)
    @Mapping(target = "products", source = "products")
    MarketOperation toMarketOperation(MarketOperationEntity marketOperationEntity);

    @InheritInverseConfiguration(name = "toMarketOperation")
    MarketOperationEntity toMarketOperationEntity(MarketOperation marketOperation);

/*    MarketOperationEntity toMarketOperationEntity(MarketOperation marketOperation);

    MarketOperation toMarketOperation(MarketOperationEntity marketOperationEntity);*/
}
