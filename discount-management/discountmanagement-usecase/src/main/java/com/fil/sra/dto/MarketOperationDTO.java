package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class MarketOperationDTO {

    protected int id;

    protected String name;

    protected Date startDate;

    protected Date endDate;

    protected List<ProductDiscountedDTO> products;

    protected TypeOfMarketOperationDTO type;

}
