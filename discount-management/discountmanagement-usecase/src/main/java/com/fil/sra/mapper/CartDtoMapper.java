package com.fil.sra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fil.sra.dto.CartDto;
import com.fil.sra.model.Cart;

@Mapper(componentModel = "spring")
public interface CartDtoMapper {
    CartDtoMapper INSTANCE = Mappers.getMapper(CartDtoMapper.class);

    public CartDto carttoDto(Cart cart);
    public Cart cartDtotoModel(CartDto cartDto);
}
