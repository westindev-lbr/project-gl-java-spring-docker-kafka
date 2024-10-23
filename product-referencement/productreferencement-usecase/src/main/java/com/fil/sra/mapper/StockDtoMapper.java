package com.fil.sra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fil.sra.dto.StockDto;
import com.fil.sra.models.Article;
import com.fil.sra.models.Stock;

@Mapper
public interface StockDtoMapper {
    StockDtoMapper INSTANCE = Mappers.getMapper(StockDtoMapper.class);

    @Mapping(source = "dto.id", target = "id")
    @Mapping(source = "dto.article", target = "article")
    @Mapping(source = "dto.quantity", target = "quantity")
    Stock toStock(StockDto dto);

    @Mapping(source = "stock.id", target = "id")
    @Mapping(source = "stock.article", target = "article")
    @Mapping(source = "stock.quantity", target = "quantity")
    StockDto toStockDto(Stock stock, Article article);
}
