package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@SuperBuilder
public abstract class MarketOperationDTO {

    protected String name;

    protected Date startDate;

    protected Date endDate;

    protected List<ProductDTO> products;

    protected TypeOfMarketOperationDTO type;

}
