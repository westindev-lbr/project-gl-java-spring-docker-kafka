package com.fil.sra.mapper;

import com.fil.sra.dto.MarketOperationLotDTO;
import com.fil.sra.model.MarketOperationLot;
import org.mapstruct.Mapper;

@Mapper
public interface MarketOperationLotDTOMapper {

    MarketOperationLotDTO toMarketOperationOneFree(MarketOperationLot marketOperationLot);

    MarketOperationLot toMarketOperationOneFreeDTO(MarketOperationLotDTO marketOperationLotDTO);

}
