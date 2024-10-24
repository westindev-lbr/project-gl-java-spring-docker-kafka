package com.fil.sra.bdd.mapper;


import com.fil.sra.bdd.entity.PerishableStockEntity;
import com.fil.sra.models.PerishableStock;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PerishableStockEntityMapper {
    PerishableStockEntityMapper INSTANCE = Mappers.getMapper(PerishableStockEntityMapper.class);
    PerishableStockEntity toPerishableStockEntity(PerishableStock stock);
    PerishableStock toPerishableStock(PerishableStockEntity entity);
}
