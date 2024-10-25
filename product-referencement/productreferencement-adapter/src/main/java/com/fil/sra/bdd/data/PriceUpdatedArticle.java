package com.fil.sra.bdd.data;


public record PriceUpdatedArticle(
    int id,
    String ean,
    double originalPrice,
    double actualPrice,
    int marketOperationId,
    int productId
) {

}