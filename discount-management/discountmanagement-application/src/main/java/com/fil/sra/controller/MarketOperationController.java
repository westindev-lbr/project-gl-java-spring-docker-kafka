package com.fil.sra.controller;

import com.fil.sra.body.AddMarketOperationQuery;
import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.dto.MarketOperationDefaultDTO;
import com.fil.sra.usecase.MarketOperationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/market-operation")
public class MarketOperationController {

    private final MarketOperationUseCase marketOperationUseCase;

    public MarketOperationController(MarketOperationUseCase marketOperationUseCase) {
        this.marketOperationUseCase = marketOperationUseCase;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<MarketOperationDTO> addMarketOperation(@RequestBody AddMarketOperationQuery addMarketOperationQuery) {
        MarketOperationDefaultDTO marketOperationDTO = MarketOperationDefaultDTO.builder()
                .startDate(addMarketOperationQuery.getStartDate())
                .endDate(addMarketOperationQuery.getEndDate())
                .discounted_value(addMarketOperationQuery.getValue())
                .isPercent(addMarketOperationQuery.isPercent()).build();
        return ResponseEntity.ofNullable(this.marketOperationUseCase.addMarketOperation(marketOperationDTO,addMarketOperationQuery.getEans()));
    }

}
