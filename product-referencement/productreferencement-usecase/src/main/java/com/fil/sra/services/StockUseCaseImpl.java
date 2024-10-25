package com.fil.sra.services;

import com.fil.sra.annotation.Usecase;
import com.fil.sra.dto.StockDto;
import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.mapper.StockDtoMapper;
import com.fil.sra.models.Article;
import com.fil.sra.models.Stock;
import com.fil.sra.ports.IArticleRepository;
import com.fil.sra.ports.IStockRepository;
import com.fil.sra.ports.IStockUseCase;

@Usecase
public class StockUseCaseImpl implements IStockUseCase {

    private final IStockRepository stockRepository;
    private final IArticleRepository articleRepository;

    public StockUseCaseImpl(
            IStockRepository stockRepository,
            IArticleRepository articleRepository) {
        this.stockRepository = stockRepository;
        this.articleRepository = articleRepository;
    }

    public StockDto updateStock(int id, int quantity) {
        Stock stock = stockRepository.updateStock(id, quantity);
        if (stock == null) {
            throw new ResourceNotFoundException("Stock not found");
        }
        Article article = articleRepository.getArticle(stock.getArticle().getId());
        if (article == null) {
            throw new ResourceNotFoundException("Article not found");
        }
        return StockDtoMapper.INSTANCE.toStockDto(stock, article);
    }
}
