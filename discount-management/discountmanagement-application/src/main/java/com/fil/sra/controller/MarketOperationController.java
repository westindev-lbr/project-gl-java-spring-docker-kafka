package com.fil.sra.controller;

import com.fil.sra.body.AddMarketOperationQuery;
import com.fil.sra.dto.MarketOperationCodeDTO;
import com.fil.sra.dto.MarketOperationDTO;
import com.fil.sra.dto.MarketOperationDefaultDTO;
import com.fil.sra.dto.ProductDTO;
import com.fil.sra.usecase.MarketOperationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller(value = "/market-operation")
public class MarketOperationController {

    private MarketOperationUseCase marketOperationUseCase;

    @PostMapping(value = "/add", consumes = "text/json")
    public ResponseEntity<MarketOperationDTO> addMarketOperation(@RequestBody AddMarketOperationQuery addMarketOperationQuery) {
        MarketOperationDefaultDTO marketOperationDTO = MarketOperationDefaultDTO.builder()
                .startDate(addMarketOperationQuery.getStartDate())
                .endDate(addMarketOperationQuery.getEndDate())
                .value(addMarketOperationQuery.getValue())
                .isPercent(addMarketOperationQuery.isPercent()).build();
        return ResponseEntity.ofNullable(this.marketOperationUseCase.addMarketOperation(marketOperationDTO,addMarketOperationQuery.getEans()));
    }

}
