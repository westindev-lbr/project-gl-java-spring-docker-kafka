package com.fil.sra.dto;

import java.util.List;

public record ArticleCommand(
        String name,
        String brand,
        double price,
        String ean,
        double vat,
        String img,
        List<String> categories,
        int quantity) {
}
