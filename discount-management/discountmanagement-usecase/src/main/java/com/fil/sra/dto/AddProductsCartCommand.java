package com.fil.sra.dto;

import java.util.List;

public record AddProductsCartCommand(
    int id,
    List<ProductCartDto> productCarts
) {

}
