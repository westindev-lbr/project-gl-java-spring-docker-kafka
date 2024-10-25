package com.fil.sra.mapper;

import com.fil.sra.dto.PerishableStockCommand;
import com.fil.sra.dto.PerishableStockDto;
import com.fil.sra.models.PerishableStock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PerishableStockDtoMapper {
    PerishableStockDtoMapper INSTANCE = Mappers.getMapper(PerishableStockDtoMapper.class);
    PerishableStockDto toDto(PerishableStock stock);
    PerishableStock toCommand(PerishableStockCommand command);

}
