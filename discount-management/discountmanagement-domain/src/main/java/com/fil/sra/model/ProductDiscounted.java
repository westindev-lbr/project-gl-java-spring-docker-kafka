package com.fil.sra.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ProductDiscounted {

    public int marketOperationId;

    public int productId;

    public double actualPrice;

    public double originalPrice;

    public String ean;
}
