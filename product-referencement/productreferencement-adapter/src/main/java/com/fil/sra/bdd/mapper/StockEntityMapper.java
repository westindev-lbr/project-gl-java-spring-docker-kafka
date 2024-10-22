package com.fil.sra.bdd.mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.fil.sra.bdd.entity.StockEntity;
import com.fil.sra.models.Stock;

import org.mapstruct.Mapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StockEntityMapper {
    StockEntityMapper INSTANCE = Mappers.getMapper(StockEntityMapper.class);
    StockEntity toStockEntity(Stock stock);
    Stock toStock(StockEntity entity);
}
