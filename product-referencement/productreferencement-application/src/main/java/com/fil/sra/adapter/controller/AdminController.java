package com.fil.sra.adapter.controller;

import com.fil.sra.bdd.service.KafkaProducerService;
import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.CreateArticleCommand;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.dto.StockDto;
import com.fil.sra.exception.NotFoundException;
import com.fil.sra.exception.CategoryNotFoundException;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.ports.IStockUseCase;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final IArticleUseCases articleUseCases;
    private final IStockUseCase stockUseCase;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public AdminController(
            IArticleUseCases articleUseCases,
            IStockUseCase stockUseCase,
            KafkaProducerService kafkaProducerService) {
        this.articleUseCases = articleUseCases;
        this.stockUseCase = stockUseCase;
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/articles/search")
    public ResponseEntity<List<ArticleDto>> getPaginatedArticles(
            @RequestParam(required = false) List<String> categories,
            @RequestParam(required = false) String subName,
            @RequestParam(defaultValue = "10") int paginationSize,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(required = false) String ean) {

        ResearchArticleRequestDto search = ResearchArticleRequestDto.builder()
                .ean(ean)
                .subName(subName)
                .categories(categories)
                .paginationSize(paginationSize)
                .pageNumber(pageNumber)
                .build();

        try {
            return ResponseEntity.ok(articleUseCases.getPaginatedArticles(search));
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/article/{articleId}/stock")
    public ResponseEntity<StockDto> updateProductStock(
            @PathVariable int articleId,
            @RequestParam int quantity) {
        try {
            StockDto stockDto = stockUseCase.updateStock(articleId, quantity);
            kafkaProducerService.sendMessage("Stock updated : " + stockDto.toString());
            return ResponseEntity.ok(stockDto);
        } catch (Exception e) {
            log.error("Error while updating stock", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/article/add")
    public ResponseEntity<ArticleDto> addArticle(@RequestBody CreateArticleCommand command) {
        try {
            ArticleDto article = articleUseCases.createArticle(command);
            kafkaProducerService.sendMessage("Article created : " + article.toString());
            return ResponseEntity.ok(article);
        } catch (NotFoundException e) {
            log.error("Error not found", e);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error while creating article", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public void ping() {
        log.info("PINGGGGGG");
    }

}
