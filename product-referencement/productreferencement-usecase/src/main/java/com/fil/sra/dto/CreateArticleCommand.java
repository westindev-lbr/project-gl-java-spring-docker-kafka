package com.fil.sra.dto;

import java.util.List;

public record CreateArticleCommand(
        String name,
        String brand,
        double price,
        String ean,
        double vat,
        String img,
        List<String> categories,
        int quantity) {
}
