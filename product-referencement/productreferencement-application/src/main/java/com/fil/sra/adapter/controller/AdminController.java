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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Search for paginated articles",
            description = "Allows administrators to search articles by category, a substring in the product name, or an exact product reference (EAN). The result is a paginated list of articles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the paginated list of articles",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ArticleDto.class)))),
            @ApiResponse(responseCode = "204", description = "No articles found matching the search criteria"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/articles/search")
    public ResponseEntity<List<ArticleDto>> getPaginatedArticles(
            @RequestParam(required = false) List<String> categories,
            @RequestParam(required = false) String subName,
            @RequestParam(defaultValue = "5") int paginationSize,
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

    @Operation(summary = "Update product stock",
            description = "Allows administrators to update the stock for products. Supports both classic products and perishable products (with expiration date). For perishable products, stock should be distinguished by expiration date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the product stock",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StockDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data or parameters"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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

    @Operation(summary = "Add a new article",
            description = "Allows administrators to add a new article to the inventory. The article details are provided in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created the article",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request or data provided"),
            @ApiResponse(responseCode = "404", description = "Related resources not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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
