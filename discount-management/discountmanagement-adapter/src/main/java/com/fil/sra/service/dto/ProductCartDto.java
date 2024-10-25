package com.fil.sra.service.dto;

public record ProductCartDto(
        int id,
        String ean,
        String name,
        double price,
        int quantity
) {

}
