package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.ProductEntity;
import com.fil.sra.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductEntityMapper {
    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);
    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity entity);
}
