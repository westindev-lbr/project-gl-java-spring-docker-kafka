package com.fil.sra.adapter.controller;

import com.fil.sra.bdd.kafka.KafkaProducerService;
import com.fil.sra.dto.*;
import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.PerishableDto;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.dto.StockDto;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.ports.IPerishableUseCase;
import com.fil.sra.ports.IPerishableStockUseCase;
import com.fil.sra.ports.IStockUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final IArticleUseCases articleUseCases;
    private final IStockUseCase stockUseCase;
    private final IPerishableUseCase perishableUseCase;
    private final KafkaProducerService kafkaProducerService;
    private final IPerishableStockUseCase perishableStockUseCase;

    @Autowired
    public AdminController(
            IArticleUseCases articleUseCases,
            IStockUseCase stockUseCase,
            IPerishableUseCase perishableUseCase,
            KafkaProducerService kafkaProducerService,
            IPerishableStockUseCase perishableStockUseCase) {
        this.articleUseCases = articleUseCases;
        this.stockUseCase = stockUseCase;
        this.perishableUseCase = perishableUseCase;
        this.kafkaProducerService = kafkaProducerService;
        this.perishableStockUseCase = perishableStockUseCase;
    }

    @Operation(summary = "Search for paginated articles", description = "Allows administrators to search articles by category, a substring in the product name, or an exact product reference (EAN). The result is a paginated list of articles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the paginated list of articles", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ArticleDto.class)))),
            @ApiResponse(responseCode = "204", description = "No articles found matching the search criteria"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/articles/search")
    public ResponseEntity<List<ArticleCommand>> getPaginatedArticles(
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
        } catch (ResourceNotFoundException e) {
            log.error("Not found Error: ", e);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Internal error : ", e);
            return ResponseEntity.badRequest().build();
        }

    }

    @Operation(summary = "Add a new article", description = "Allows administrators to add a new article to the inventory. The article details are provided in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created the article", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request or data provided"),
            @ApiResponse(responseCode = "404", description = "Related resources not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/article/add")
    public ResponseEntity<ArticleDto> addArticle(@RequestBody ArticleCommand command) {
        try {
            ArticleDto article = articleUseCases.createArticle(command);
            return ResponseEntity.ok(article);
        } catch (ResourceNotFoundException e) {
            log.error("Error not found", e);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error while creating article", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Update an article", description = "Updates an existing article with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad request - Error during update"),
            @ApiResponse(responseCode = "404", description = "Article not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/articles/{articleId}")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable Integer articleId,
            @RequestBody ArticleCommand command) {
        try {
            ArticleDto article = articleUseCases.updateArticle(articleId, command);
            return ResponseEntity.ok(article);
        } catch (ResourceNotFoundException e) {
            log.error("Error not found", e);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error while creating article", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete an article", description = "Deletes an article from the database by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully deleted", content = @Content(mediaType = "application/json", schema = @Schema(example = "Successfully deleted article (id : 1 )"))),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content(mediaType = "application/json", schema = @Schema(example = "Article not found"))),
            @ApiResponse(responseCode = "400", description = "Bad request - Error during deletion", content = @Content(mediaType = "application/json", schema = @Schema(example = "Error while deleting article"))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity<Map<String, Object>> deleteArticle(@PathVariable Integer articleId) {
        Map<String, Object> response = new HashMap<>();

        try {
            articleUseCases.deleteArticle(articleId);
            response.put("message", "Successfully deleted article");
            response.put("articleId", articleId);
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException e) {
            log.error("Error not found", e);
            response.put("message", "Article not found");
            response.put("articleId", articleId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception e) {
            log.error("Error while deleting article", e);
            response.put("message", "Error while deleting article");
            response.put("articleId", articleId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @Operation(summary = "Update product stock", description = "Allows administrators to update the stock for products. Supports both classic products and perishable products (with expiration date). For perishable products, stock should be distinguished by expiration date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the product stock", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StockDto.class))),
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

    @Operation(summary = "Add a new perishable stock entry", description = "Adds a new perishable stock entry to the database, including details like quantity and best-before date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added perishable stock", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PerishableStockDto.class))),
            @ApiResponse(responseCode = "404", description = "Resource not found - specified perishable entity does not exist", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad request - error occurred during the stock addition process", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/perishables/stock")
    public ResponseEntity<PerishableStockDto> addPerishableStock(@RequestBody PerishableStockCommand command) {
        try {
            return ResponseEntity.ok(perishableStockUseCase.addPerishableStock(command));
        } catch (ResourceNotFoundException e) {
            log.error("NotFoundError during perishable stock", e);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error while updating stock", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/article/perishable/expired")
    public ResponseEntity<List<PerishableDto>> getExpiredPerishables() {
        try {
            return ResponseEntity.ok(perishableUseCase.getExpiredPerishables());
        } catch (Exception e) {
            log.error("Error while getting expired perishables", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public void ping() {
        log.info("PINGGGGGG");
    }

}
