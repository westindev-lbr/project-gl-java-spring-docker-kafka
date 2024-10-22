package com.fil.sra.mapper;

import com.fil.sra.dto.*;
import com.fil.sra.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MapperDTOToModelVV {

    @SubclassMapping(source = MarketOperationDefaultDTO.class, target = MarketOperationDefault.class)
    @SubclassMapping(source = MarketOperationCodeDTO.class, target = MarketOperationCode.class)
    @SubclassMapping(source = MarketOperationLeastPriceyDTO.class, target = MarketOperationLeastPricey.class)
    @SubclassMapping(source = MarketOperationLotDTO.class, target = MarketOperationLot.class)
    @SubclassMapping(source = MarketOperationOneFreeDTO.class, target = MarketOperationOneFree.class)
    MarketOperation toMarketOperation(MarketOperationDTO marketOperationDTO);

    @SubclassMapping(source = MarketOperationDefault.class, target = MarketOperationDefaultDTO.class)
    @SubclassMapping(source = MarketOperationCode.class, target = MarketOperationCodeDTO.class)
    @SubclassMapping(source = MarketOperationLeastPricey.class, target = MarketOperationLeastPriceyDTO.class)
    @SubclassMapping(source = MarketOperationLot.class, target = MarketOperationLotDTO.class)
    @SubclassMapping(source = MarketOperationOneFree.class, target = MarketOperationOneFreeDTO.class)
    MarketOperationDTO toMarketOperationDTO(MarketOperation marketOperation);
}
