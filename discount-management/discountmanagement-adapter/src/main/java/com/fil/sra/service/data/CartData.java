package com.fil.sra.service.data;

import java.util.List;

public record CartData(
        int id,
        int userId,
        List<ProductCartData> productsCart,
        int totalAmount
) {

}
