package com.fil.sra.services;

import com.fil.sra.annotation.Usecase;
import com.fil.sra.dto.ArticleDto;
import com.fil.sra.dto.ArticleCommand;
import com.fil.sra.dto.ResearchArticleRequestDto;
import com.fil.sra.exception.DataIntegrityViolationException;
import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.mapper.ArticleCommandMapper;
import com.fil.sra.mapper.ArticleDtoMapper;
import com.fil.sra.models.Article;
import com.fil.sra.models.Category;
import com.fil.sra.models.Stock;
import com.fil.sra.ports.IArticleRepository;
import com.fil.sra.ports.IArticleUseCases;
import com.fil.sra.ports.ICategoryRepository;
import com.fil.sra.ports.IStockRepository;

import java.util.ArrayList;
import java.util.List;

@Usecase
public class ArticleUseCasesImpl implements IArticleUseCases {

    private final IArticleRepository articleRepository;
    private final IStockRepository stockRepository;
    private final ICategoryRepository categoryRepository;

    public ArticleUseCasesImpl(
            IArticleRepository articleRepository,
            IStockRepository stockRepository,
            ICategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.stockRepository = stockRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ArticleCommand> getPaginatedArticles(ResearchArticleRequestDto search) {

        List<String> categoryNames = search.getCategories();
        List<Category> categories = new ArrayList<>();

        // On vérifie les catégories
        if (categoryNames != null && !categoryNames.isEmpty()) {
            categories =  categoryNames.stream().map(name -> {
                Category category = categoryRepository.getCategoryByName(name);
                if (category == null) {
                    throw new ResourceNotFoundException("Category " + name + " not found");
                }
                return category;
            }).toList();
        }

        List<Article> articles = articleRepository.getArticlesByCriteria(
            search.getEan(),
            search.getSubName(),
                categories,
            search.getPaginationSize(),
            search.getPageNumber());

        return articles.stream().map(article -> {
            Stock stockArticle = stockRepository.getStockByArticleId(article.getId());
            int quantity = (stockArticle != null) ? stockArticle.getQuantity() : 0;
            return ArticleCommandMapper.INSTANCE.toArticleCommand(article,quantity);
        }).toList();
    }

    @Override
    public ArticleDto createArticle(ArticleCommand command) {

        List<Category> categories = command.categories()
                .stream()
                .map(categoryRepository::getCategoryByName)
                .toList();

        Article article = ArticleCommandMapper.INSTANCE.toArticle(command,categories);

        Article articleSaved = articleRepository.addArticle(article, command.quantity());
        if (articleSaved == null) {
            throw new DataIntegrityViolationException("Article not saved");
        }

        Stock stockArticle = stockRepository.getStockByArticleId(articleSaved.getId());
        if (stockArticle == null) {
            throw new ResourceNotFoundException("Stock not found");
        }

        return ArticleDtoMapper.INSTANCE.toArticleWithQuantityDto(articleSaved, stockArticle.getQuantity());
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteArticle(id);
    }

    @Override
    public ArticleDto updateArticle(Integer id,ArticleCommand command) {
        Article Articlefound = articleRepository.getArticle(id);
        if(Articlefound == null){
            throw new ResourceNotFoundException("Article not found");
        }
        List<Category> categories = categoryRepository.getAllCategoryByNames(command.categories());
        Article article = ArticleCommandMapper.INSTANCE.toArticle(command,categories);
        article.setId(id);
        return ArticleDtoMapper.INSTANCE.toArticleDto(articleRepository.updateArticle(article));
    }
}
