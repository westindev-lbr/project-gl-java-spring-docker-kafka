package com.fil.sra.mapper;

import com.fil.sra.dto.MarketOperationDefaultDTO;
import com.fil.sra.model.MarketOperationDefault;
import org.mapstruct.Mapper;

@Mapper
public interface MarketOperationDefaultDTOMapper {

    MarketOperationDefaultDTO toMarketOperationDefault(MarketOperationDefault marketOperationDefault);

    MarketOperationDefault toMarketOperationDefaultDTO(MarketOperationDefaultDTO marketOperationDefaultDTO);
}
