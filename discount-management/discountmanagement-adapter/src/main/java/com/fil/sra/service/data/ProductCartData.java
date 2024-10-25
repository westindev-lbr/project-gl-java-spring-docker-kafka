package com.fil.sra.service.data;

public record ProductCartData(
        int id,
        String ean,
        String name,
        double price,
        int quantity
) {

}
