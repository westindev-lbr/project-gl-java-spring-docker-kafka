package com.fil.sra.mapper;

import com.fil.sra.dto.ProductDiscountedDTO;
import com.fil.sra.model.ProductDiscounted;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { MapperDTOToModelVV.class })
public interface MapperProductDiscountedDTOToModelVV {
    ProductDiscounted productDiscountedDTOtoModel(ProductDiscountedDTO productDiscountedDTO);
    ProductDiscountedDTO productDiscountedToDTO(ProductDiscounted productDiscounted);
}
