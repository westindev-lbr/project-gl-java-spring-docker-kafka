package com.fil.sra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fil.sra.dto.ProductCartDto;
import com.fil.sra.model.ProductCart;

@Mapper(componentModel = "spring")
public interface ProductCartDtoMapper {
    ProductCartDtoMapper INSTANCE = Mappers.getMapper(ProductCartDtoMapper.class);

    public ProductCartDto produtCarttoDto(ProductCart productCart);
    public ProductCart productCartDtotoModel(ProductCartDto productCartDto);
}
