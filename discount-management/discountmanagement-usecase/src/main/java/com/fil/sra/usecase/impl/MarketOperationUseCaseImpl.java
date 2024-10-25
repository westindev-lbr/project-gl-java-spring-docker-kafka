package com.fil.sra.usecase.impl;

import com.fil.sra.annotation.Usecase;
import com.fil.sra.command.AddMarketOperationCommand;
import com.fil.sra.dto.*;
import com.fil.sra.exception.ProductDoesNotExistException;
import com.fil.sra.exception.TypeOfMarketOperationDoesnotExistException;
import com.fil.sra.mapper.MapperDTOToModelVV;
import com.fil.sra.model.MarketOperation;
import com.fil.sra.repository.MarketOperationRepository;
import com.fil.sra.usecase.MarketOperationUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Usecase
public class MarketOperationUseCaseImpl implements MarketOperationUseCase {

    private final MarketOperationRepository marketOperationRepository;

    private final MapperDTOToModelVV mapperDTOToModelVV;

    public MarketOperationUseCaseImpl(MarketOperationRepository marketOperationRepository, MapperDTOToModelVV mapperDTOToModelVV) {
        this.marketOperationRepository = marketOperationRepository;
        this.mapperDTOToModelVV =  mapperDTOToModelVV;
    }

    public MarketOperationDTO addMarketOperation(AddMarketOperationCommand addMarketOperationCommand, TypeOfMarketOperationDTO typeOfMarketOperationDTO) {
        try {
        MarketOperationDTO marketOperationDTO = createMarketOperationDTO(addMarketOperationCommand,typeOfMarketOperationDTO);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(String ean : addMarketOperationCommand.getEans()){
            ProductDTO productDTO = ProductDTO.builder()
                    .ean(ean)
                    .build();
            productDTOS.add(productDTO);
        }
        marketOperationDTO.setProducts(productDTOS);
        MarketOperation marketOperation = marketOperationRepository.addOperation(mapperDTOToModelVV.toMarketOperation(marketOperationDTO));
        return mapperDTOToModelVV.toMarketOperationDTO(marketOperation);
        } catch (ProductDoesNotExistException e){
            System.out.println(e.getMessage());
            return null;
        }
        // SEND KAFKA IF VALIDE SINON RETURN null
    }

    public List<MarketOperationDTO> getAllMarketOperations() {
        List<MarketOperation> marketOperations = this.marketOperationRepository.getAllMarketOperations();
        List<MarketOperationDTO> marketOperationDTOS = new ArrayList<>();
        for(MarketOperation marketOperation : marketOperations){
            marketOperationDTOS.add(mapperDTOToModelVV.toMarketOperationDTO(marketOperation));
        }
        return marketOperationDTOS;
    }

    public MarketOperationDTO getMarketOperationById(int id) {
        return this.mapperDTOToModelVV.toMarketOperationDTO(this.marketOperationRepository.getMarketOperationById(id));
    }

    public void deleteMarketOperationById(int id) {
        this.marketOperationRepository.deleteMarketOperationById(id);
    }

    private MarketOperationDTO createMarketOperationDTO(AddMarketOperationCommand addMarketOperationCommand, TypeOfMarketOperationDTO typeOfMarketOperationDTO) throws TypeOfMarketOperationDoesnotExistException {
        if(typeOfMarketOperationDTO == TypeOfMarketOperationDTO.DEFAULT
            && Objects.isNull(addMarketOperationCommand.isPercent) &&
                    !Objects.isNull(addMarketOperationCommand.value)){
                return MarketOperationDefaultDTO.builder()
                        .startDate(addMarketOperationCommand.startDate)
                        .endDate(addMarketOperationCommand.endDate)
                        .isPercent(addMarketOperationCommand.isPercent)
                        .discounted_value(addMarketOperationCommand.value)
                        .build();
            }
        else if (typeOfMarketOperationDTO == TypeOfMarketOperationDTO.CODE &&
            !Objects.isNull(addMarketOperationCommand.isPercent) &&
                    !Objects.isNull(addMarketOperationCommand.value) &&
                    !Objects.isNull(addMarketOperationCommand.code)){
                return MarketOperationCodeDTO.builder()
                        .startDate(addMarketOperationCommand.startDate)
                        .endDate(addMarketOperationCommand.endDate)
                        .isPercent(addMarketOperationCommand.isPercent)
                        .discounted_value(addMarketOperationCommand.value)
                        .code(addMarketOperationCommand.code).build();
            }
            else if(typeOfMarketOperationDTO == TypeOfMarketOperationDTO.LOT &&
                !Objects.isNull(addMarketOperationCommand.numberForLot) &&
                !Objects.isNull(addMarketOperationCommand.priceForLot)){
                    return MarketOperationLotDTO.builder()
                            .startDate(addMarketOperationCommand.startDate)
                            .endDate(addMarketOperationCommand.endDate)
                            .priceForLot(addMarketOperationCommand.priceForLot)
                            .numberForLot(addMarketOperationCommand.numberForLot).build();
                }
            else if(typeOfMarketOperationDTO == TypeOfMarketOperationDTO.ONE_FREE &&
                !Objects.isNull(addMarketOperationCommand.numberForOneFree)){
                    return MarketOperationOneFreeDTO.builder()
                            .startDate(addMarketOperationCommand.startDate)
                            .endDate(addMarketOperationCommand.endDate)
                            .numberForOneFree(addMarketOperationCommand.numberForOneFree).build();
                }
            else if(typeOfMarketOperationDTO == TypeOfMarketOperationDTO.LEAST_PRICEY
                && !Objects.isNull(addMarketOperationCommand.value) &&
                !Objects.isNull(addMarketOperationCommand.isPercent)){
                    return MarketOperationLeastPriceyDTO.builder()
                            .startDate(addMarketOperationCommand.startDate)
                            .endDate(addMarketOperationCommand.endDate)
                            .discounted_value(addMarketOperationCommand.value)
                            .isPercent(addMarketOperationCommand.isPercent).build();
                }
         else {
            throw new TypeOfMarketOperationDoesnotExistException("The Type you specified doesn't exist");
        }
    }


}
