package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.entity.StockEntity;
import com.fil.sra.bdd.mapper.ArticleEntityMapper;
import com.fil.sra.bdd.mapper.CategoryEntityMapper;
import com.fil.sra.bdd.mapper.StockEntityMapper;
import com.fil.sra.models.Article;
import com.fil.sra.ports.IArticleRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleRepositoryImpl implements IArticleRepository {

    private final ArticleJPARepository articleJPARepository;
    private final ArticleEntityMapper articleEntityMapper;
    private final CategoryJPARepository categoryJPARepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final StockJPARepository stockJPARepository;
    private final StockEntityMapper stockEntityMapper;

    public ArticleRepositoryImpl(
            ArticleJPARepository articleJPARepository,
            ArticleEntityMapper articleEntityMapper,
            CategoryJPARepository categoryJPARepository,
            CategoryEntityMapper categoryEntityMapper,
            StockJPARepository stockJPARepository,
            StockEntityMapper stockEntityMapper) {
        this.articleJPARepository = articleJPARepository;
        this.articleEntityMapper = articleEntityMapper;
        this.categoryJPARepository = categoryJPARepository;
        this.categoryEntityMapper = categoryEntityMapper;
        this.stockJPARepository = stockJPARepository;
        this.stockEntityMapper = stockEntityMapper;
    }

    @Override
    public List<Article> getArticlesByCriteria(Integer articleId, String subName, List<String> categories,
            int paginationSize, int pageNumber) {
        List<Article> results;
        if (articleId != null) {
            ArticleEntity article = articleJPARepository.findById(articleId).orElse(null);
            results = (article != null) ? List.of(articleEntityMapper.toArticle(article)) : new ArrayList<>();
        } else {
            List<CategoryEntity> categoryEntities = categories.stream()
                    .map(name -> categoryJPARepository.findByName(name).orElse(null)).filter(cat -> cat != null)
                    .toList();
            Page<ArticleEntity> articles = articleJPARepository.findByNameContainingAndCategoriesIn(subName,
                    categoryEntities, PageRequest.of(pageNumber, paginationSize));
            results = articles.getContent().stream()
                    .filter(art -> categoryEntities.stream().map(CategoryEntity::getName).collect(Collectors.toSet())
                            .containsAll(art.getCategories().stream().map(CategoryEntity::getName)
                                    .collect(Collectors.toSet())))
                    .map(art -> articleEntityMapper.toArticle(art)).toList();
        }
        return results;
    }

    @Override
    public Article addArticle(Article article) {
        ArticleEntity articleEntity = articleEntityMapper.toArticleEntity(article);
        ArticleEntity articleSaved = articleJPARepository.save(articleEntity);
        if (articleSaved == null)
            return null;

        StockEntity stockEntity = new StockEntity();
        stockEntity.setQuantity(0);
        stockEntity.setArticle(articleSaved);

        StockEntity stockSaved = stockJPARepository.save(stockEntity);
        if (stockSaved == null)
            return null;
        return articleEntityMapper.toArticle(articleSaved);
    }
}
