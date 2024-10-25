package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.ProductDiscountedEntity;
import com.fil.sra.model.ProductDiscounted;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { MapperEntityToModelVV.class })
public interface MapperProductDiscountedEntityToModelVV {

    @Mapping(source = "marketOperationId", target = "marketOperation.id")
    ProductDiscountedEntity productDiscountedToEntity(ProductDiscounted productDiscounted);

    @InheritInverseConfiguration(name = "productDiscountedToEntity")
    ProductDiscounted productedDiscountedEntityToModel(ProductDiscountedEntity productDiscountedEntity);

}
