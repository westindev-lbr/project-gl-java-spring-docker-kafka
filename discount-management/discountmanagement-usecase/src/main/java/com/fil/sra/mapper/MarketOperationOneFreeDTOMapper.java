package com.fil.sra.mapper;

import com.fil.sra.dto.MarketOperationOneFreeDTO;
import com.fil.sra.model.MarketOperationOneFree;

public interface MarketOperationOneFreeDTOMapper {

    MarketOperationOneFreeDTO toMarketOperationOneFree(MarketOperationOneFree marketOperationOneFree);

    MarketOperationOneFree toMarketOperationOneFreeDTO(MarketOperationOneFreeDTO marketOperationOneFreeDTO);

}
