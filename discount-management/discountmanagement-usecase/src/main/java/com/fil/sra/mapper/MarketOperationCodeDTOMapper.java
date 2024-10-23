package com.fil.sra.mapper;

import com.fil.sra.dto.MarketOperationCodeDTO;
import com.fil.sra.model.MarketOperationCode;
import org.mapstruct.Mapper;

@Mapper
public interface MarketOperationCodeDTOMapper {

    MarketOperationCodeDTO toMarketOperationCode(MarketOperationCode marketOperationCode);

    MarketOperationCode toMarketOperationCodeDTO(MarketOperationCodeDTO marketOperationCodeDTO);

}
