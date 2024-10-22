package com.fil.sra.mapper;

import com.fil.sra.dto.*;
import com.fil.sra.model.*;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION/* ,uses = { MarketOperationDefaultDTOMapper.class, MarketOperationLotDTOMapper.class, MarketOperationCodeDTOMapper.class, MarketOperationOneFreeDTOMapper.class, MarketOperationLeastPriceyDTOMapper.class }*/)
public interface MapperDTOToModelVV {

    @SubclassMapping(source = MarketOperationDefaultDTO.class, target = MarketOperationDefault.class)
    @SubclassMapping(source = MarketOperationCodeDTO.class, target = MarketOperationCode.class)
    @SubclassMapping(source = MarketOperationLeastPriceyDTO.class, target = MarketOperationLeastPricey.class)
    @SubclassMapping(source = MarketOperationLotDTO.class, target = MarketOperationLot.class)
    @SubclassMapping(source = MarketOperationOneFreeDTO.class, target = MarketOperationOneFree.class)
    MarketOperation toMarketOperation(MarketOperationDTO marketOperationDTO);


    @InheritInverseConfiguration(name= "toMarketOperation")
    MarketOperationDTO toMarketOperationDTO(MarketOperation marketOperation);

/*    MarketOperationDTO toMarketOperationEntity(MarketOperation marketOperation);

    MarketOperation toMarketOperation(MarketOperationDTO marketOperationDTO);*/

}
