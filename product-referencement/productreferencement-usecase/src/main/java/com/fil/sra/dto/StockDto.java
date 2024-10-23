package com.fil.sra.dto;

public record StockDto(
        int id,
        int quantity,
        ArticleDto article
) {

}
