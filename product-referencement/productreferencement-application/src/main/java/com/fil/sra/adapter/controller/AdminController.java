package com.fil.sra.adapter.controller;

import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.ports.IArticleUseCases;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    private final IArticleUseCases articleUseCases;

    public AdminController(IArticleUseCases articleUseCases){
        this.articleUseCases = articleUseCases;
    }
    @GetMapping("/articles/search")
    public ResponseEntity<List<ArticleDto>> getPaginatedArticles(
            @RequestParam(required = false) List<String> categories,
            @RequestParam(required = false) String subName,
            @RequestParam(defaultValue = "10") int paginationSize,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(required = false) Integer articleId){

        ResearchArticleRequestDto search = ResearchArticleRequestDto.builder()
                .articleId(articleId)
                .subName(subName)
                .categories(categories)
                .paginationSize(paginationSize)
                .pageNumber(pageNumber)
                .build();

        return ResponseEntity.ok(articleUseCases.getPaginatedArticles(search));
    }

    @GetMapping("/")
    public void ping(){
        log.info("PINGGGGGG");
    }

}
