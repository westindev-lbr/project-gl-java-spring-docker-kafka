package com.fil.sra.controller;

import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.usecase.MarketOperationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller(value = "/market-operation")
public class MarketOperationController {

    private MarketOperationUseCase marketOperationUseCase;

    @PostMapping(value = "/add", consumes = "text/json")
    public ResponseEntity<MarketOperationDTO> addMarketOperation(@RequestBody MarketOperationDTO marketOperationDTO){
        return ResponseEntity.ofNullable(this.marketOperationUseCase.addMarketOperation(marketOperationDTO));
    }

}
