package com.fil.sra.bdd.mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.fil.sra.bdd.entity.StockEntity;
import com.fil.sra.models.Stock;

import org.mapstruct.Mapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StockEntityMapper {
    StockEntityMapper INSTANCE = Mappers.getMapper(StockEntityMapper.class);

    @Mapping(target = "article", ignore = true)
    StockEntity toStockEntity(Stock stock);
    @Mapping(target = "article", ignore = true)
    Stock toStock(StockEntity entity);
}
