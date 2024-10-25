package com.fil.sra.bdd.mapper;

import com.fil.sra.bdd.entity.TypeOfMarketOperationEntity;
import com.fil.sra.model.TypeMarketOperation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperTypeMarketOperationEntityToModelVV {

    TypeMarketOperation typeMarketOperationEntityToModel(TypeOfMarketOperationEntity typeOfMarketOperationEntity);

    TypeOfMarketOperationEntity typeMarketOperationToEntity(TypeMarketOperation typeMarketOperation);

}
