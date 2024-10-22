package com.fil.sra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {

    private int actualPrice;

    private int originalPrice;

    private String name;
}
