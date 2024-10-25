package com.fil.sra.bdd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.fil.sra.model.Cart;
import com.fil.sra.service.data.CartData;


@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface DataMapper {
    DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

    @Mapping(target = "amount", source = "totalAmount")
    Cart toCart(CartData data);
    @Mapping(target = "totalAmount", source = "amount")
    CartData toCartData(Cart cart);
}
