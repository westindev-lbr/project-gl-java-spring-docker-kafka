package com.fil.sra.adapter.controller;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.CreateArticleCommand;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.exception.NotFoundException;
import com.fil.sra.exception.CategoryNotFoundException;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.ports.IStockUseCase;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
            @RequestParam(required = false) String ean){

        ResearchArticleRequestDto search = ResearchArticleRequestDto.builder()
                .ean(ean)
                .subName(subName)
                .categories(categories)
                .paginationSize(paginationSize)
                .pageNumber(pageNumber)
                .build();

        try {
            return ResponseEntity.ok(articleUseCases.getPaginatedArticles(search));
        }catch (CategoryNotFoundException e){
            return ResponseEntity.notFound().build();
        }

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

    @PostMapping("/article/add")
    public ResponseEntity<ArticleDto> addArticle(@RequestBody CreateArticleCommand command) {
        try {
            return ResponseEntity.ok(articleUseCases.createArticle(command));
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
