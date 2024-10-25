package com.fil.sra.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fil.sra.dto.PerishableDto;
import com.fil.sra.models.Perishable;

@Mapper
public interface PerishableDtoMapper {
    PerishableDtoMapper INSTANCE = Mappers.getMapper(PerishableDtoMapper.class);

    @Mapping(source = "bestBefore", target = "expirationDate")
    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "stock.quantity", target = "quantity")
    PerishableDto toPerishableDto(Perishable perishable);

}
