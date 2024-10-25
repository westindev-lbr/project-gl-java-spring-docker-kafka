package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductDiscountedDTO {

    public int marketOperationId;

    public int productId;

    public double actualPrice;

    public double originalPrice;

    public String ean;
}
