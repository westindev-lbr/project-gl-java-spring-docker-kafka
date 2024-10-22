package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.PerishableEntity;
import com.fil.sra.models.Perishable;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PerishableEntityMapper {
    PerishableEntityMapper INSTANCE = Mappers.getMapper(PerishableEntityMapper.class);
    PerishableEntity toPerishableEntity(Perishable perishable);
    Perishable toPerishable(PerishableEntity entity);
}
