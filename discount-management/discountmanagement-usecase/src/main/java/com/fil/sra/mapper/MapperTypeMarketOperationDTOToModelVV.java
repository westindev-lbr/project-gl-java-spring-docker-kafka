package com.fil.sra.mapper;

import com.fil.sra.dto.TypeOfMarketOperationDTO;
import com.fil.sra.model.TypeMarketOperation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperTypeMarketOperationDTOToModelVV {

    TypeOfMarketOperationDTO typeMarketOperationDTOToModel(TypeMarketOperation typeMarketOperation);

    TypeMarketOperation typeMarketOperationToDTO(TypeOfMarketOperationDTO typeOfMarketOperationDTO);
}
