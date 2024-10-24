package com.fil.sra.controller;

import com.fil.sra.command.AddMarketOperationCommand;
import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.dto.MarketOperationDefaultDTO;
import com.fil.sra.dto.TypeOfMarketOperationDTO;
import com.fil.sra.usecase.MarketOperationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/market-operation")
public class MarketOperationController {

    private final MarketOperationUseCase marketOperationUseCase;

    public MarketOperationController(MarketOperationUseCase marketOperationUseCase) {
        this.marketOperationUseCase = marketOperationUseCase;
    }

    @PostMapping(value = "/add/{type}", consumes = "application/json")
    public ResponseEntity<MarketOperationDTO> addMarketOperation(@RequestBody  AddMarketOperationCommand addMarketOperationCommand, @PathVariable(value = "type")String type) {
        try{
            TypeOfMarketOperationDTO typeOfMarketOperationDTO = TypeOfMarketOperationDTO.valueOf(type);
            return ResponseEntity.ofNullable(this.marketOperationUseCase.addMarketOperation(addMarketOperationCommand, typeOfMarketOperationDTO));

        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<MarketOperationDTO>> getAllMarketOperations(){
        return ResponseEntity.ok(this.marketOperationUseCase.getAllMarketOperations());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MarketOperationDTO> getMarketOperationById(@PathVariable(value = "id") int id){
        return ResponseEntity.ofNullable(this.marketOperationUseCase.getMarketOperationById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMarketOperationById(@PathVariable(value = "id") int id){
        this.marketOperationUseCase.deleteMarketOperationById(id);
        return ResponseEntity.ok().build();
    }
}
