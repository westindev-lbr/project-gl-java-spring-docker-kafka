package com.fil.sra.controller;

import com.fil.sra.command.AddMarketOperationCommand;
import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.dto.TypeOfMarketOperationDTO;
import com.fil.sra.exception.TypeOfMarketOperationDoesnotExistException;
import com.fil.sra.service.kafka.KafkaProducerService;
import com.fil.sra.usecase.MarketOperationUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/market-operation")
public class MarketOperationController {

    private final MarketOperationUseCase marketOperationUseCase;
    private final KafkaProducerService kafkaProducerService;

    public MarketOperationController(
            MarketOperationUseCase marketOperationUseCase,
            KafkaProducerService kafkaProducerService) {
        this.marketOperationUseCase = marketOperationUseCase;
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping(value = "/add/{type}", consumes = "application/json")
    @Operation(description = "Add Market Operation based on the query")
    @ApiResponse(responseCode = "200", description = "Manage to create the discount")
    @ApiResponse(responseCode = "400", description = "If Type entered is not good ")
    public ResponseEntity<MarketOperationDTO> addMarketOperation(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Command so that you can create a market operation") @RequestBody  AddMarketOperationCommand addMarketOperationCommand,
                                                                 @Parameter(description = "Type of TypeMarketOperation", example = "CODE")@PathVariable(value = "type")String type) {
        try{
            TypeOfMarketOperationDTO typeOfMarketOperationDTO = TypeOfMarketOperationDTO.valueOf(type);
            
            MarketOperationDTO marketOperationDTOResponse = this.marketOperationUseCase.addMarketOperation(addMarketOperationCommand,
            typeOfMarketOperationDTO);
            if (marketOperationDTOResponse.getType().equals(TypeOfMarketOperationDTO.DEFAULT)) {
                this.kafkaProducerService.sendMessage(marketOperationDTOResponse);
            }
            return ResponseEntity.ok(marketOperationDTOResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (TypeOfMarketOperationDoesnotExistException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/")
    @Operation(description = "Get all market operations")
    @ApiResponse(responseCode = "200", description = "Get all possibles market operations")
    public ResponseEntity<List<MarketOperationDTO>> getAllMarketOperations(){
        return ResponseEntity.ok(this.marketOperationUseCase.getAllMarketOperations());
    }


    @GetMapping(value = "/{id}")
    @Operation(description = "Get all market operations")
    @ApiResponse(responseCode = "200", description = "Get market operations")
    @ApiResponse(responseCode = "404", description = "No Market Operation with this id")
    public ResponseEntity<MarketOperationDTO> getMarketOperationById(@Parameter(description = "id of market operation", example = "1")@PathVariable(value = "id") int id){
        return ResponseEntity.ofNullable(this.marketOperationUseCase.getMarketOperationById(id));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(description = "Get all market operations")
    @ApiResponse(responseCode = "200", description = "Deleted market operation")
    public ResponseEntity<Void> deleteMarketOperationById(@Parameter(description = "Id for MarketOperation to be deleted", example = "1") @PathVariable(value = "id") int id){
        this.marketOperationUseCase.deleteMarketOperationById(id);
        return ResponseEntity.ok().build();
    }
}
