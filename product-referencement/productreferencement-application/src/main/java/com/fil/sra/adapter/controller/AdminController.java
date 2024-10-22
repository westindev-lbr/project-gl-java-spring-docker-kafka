package com.fil.sra.adapter.controller;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.ports.IStockUseCase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final IArticleUseCases articleUseCases;
    private final IStockUseCase stockUseCase;

    public AdminController(
            IArticleUseCases articleUseCases,
            IStockUseCase stockUseCase) {
        this.articleUseCases = articleUseCases;
        this.stockUseCase = stockUseCase;
    }

    @GetMapping("/articles/search")
    public ResponseEntity<List<ArticleDto>> getPaginatedArticles(
            @RequestParam(required = false) List<String> categories,
            @RequestParam(required = false) String subName,
            @RequestParam(defaultValue = "10") int paginationSize,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(required = false) Integer articleId) {

        ResearchArticleRequestDto search = ResearchArticleRequestDto.builder()
                .articleId(articleId)
                .subName(subName)
                .categories(categories)
                .paginationSize(paginationSize)
                .pageNumber(pageNumber)
                .build();

        return ResponseEntity.ok(articleUseCases.getPaginatedArticles(search));
    }

    @PutMapping("/article/{articleId}/stock")
    public ResponseEntity<Void> updateProductStock(
            @PathVariable int articleId,
            @RequestParam int quantity) {
        try {
            stockUseCase.updateStock(articleId, quantity);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error while updating stock", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public void ping() {
        log.info("PINGGGGGG");
    }

}
