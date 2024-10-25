package com.fil.sra.dto;

import java.util.List;

public record PerishableDto(
        int id,
        String lot,
        String ean,
        String name,
        String brand,
        double price,
        String expirationDate,
        List<CategoryDto> categories,
        int quantity) {
}
