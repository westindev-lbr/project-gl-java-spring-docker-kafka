package com.fil.sra.usecase.impl;

import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.dto.ProductDTO;
import com.fil.sra.exception.ProductDoesNotExistException;
import com.fil.sra.mapper.MapperDTOToModelVV;
import com.fil.sra.model.MarketOperation;
import com.fil.sra.repository.MarketOperationRepository;
import com.fil.sra.usecase.MarketOperationUseCase;

import java.util.List;

public class MarketOperationUseCaseImpl implements MarketOperationUseCase {

    public MarketOperationRepository marketOperationRepository;

    private MapperDTOToModelVV mapperDTOToModelVV;

    public MarketOperationDTO addMarketOperation(MarketOperationDTO marketOperationDTO, List<String> eans) {
        List<ProductDTO> productDTOS = List.of();
        for(String ean : eans){
            ProductDTO productDTO = ProductDTO.builder()
                    .ean(ean)
                    .build();
            productDTOS.add(productDTO);
        }
        marketOperationDTO.setProducts(productDTOS);
        try {
            MarketOperation marketOperation = marketOperationRepository.addOperation(mapperDTOToModelVV.toMarketOperation(marketOperationDTO));
            return mapperDTOToModelVV.toMarketOperationDTO(marketOperation);
        } catch (ProductDoesNotExistException e){
            System.out.println(e.getMessage());
            return null;
        }
        // SEND KAFKA IF VALIDE SINON RETURN null
    }
}
