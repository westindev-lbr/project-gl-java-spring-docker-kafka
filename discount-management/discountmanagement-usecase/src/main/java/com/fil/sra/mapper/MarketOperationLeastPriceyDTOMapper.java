package com.fil.sra.mapper;

import com.fil.sra.dto.MarketOperationLeastPriceyDTO;
import com.fil.sra.model.MarketOperationLeastPricey;

public interface MarketOperationLeastPriceyDTOMapper {

    MarketOperationLeastPriceyDTO toMarketOperationLeastPricey(MarketOperationLeastPricey marketOperationLeastPricey);

    MarketOperationLeastPricey toMarketOperationLeastPriceyDTO(MarketOperationLeastPriceyDTO marketOperationLeastPriceyDTO);

}
