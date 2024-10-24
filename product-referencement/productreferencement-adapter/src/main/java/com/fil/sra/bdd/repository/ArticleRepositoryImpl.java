package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.entity.StockEntity;
import com.fil.sra.bdd.mapper.ArticleEntityMapper;
import com.fil.sra.bdd.mapper.CategoryEntityMapper;
import com.fil.sra.bdd.mapper.StockEntityMapper;
import com.fil.sra.bdd.specification.ArticleSpecification;
import com.fil.sra.exception.NotFoundException;
import com.fil.sra.models.Article;
import com.fil.sra.models.Category;
import com.fil.sra.ports.IArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public List<Article> getArticlesByCriteria(String ean, String subName, List<Category> categories, int paginationSize,
            int pageNumber) throws NotFoundException {

        List<CategoryEntity> categoryEntities = categories.stream().map(categoryEntityMapper::toCategoryEntity).toList();

        // Création dynamique des critères de recherche
        Specification<ArticleEntity> spec = Specification.where(ArticleSpecification.hasEan(ean))
                .and(ArticleSpecification.hasNameContaining(subName))
                .and(ArticleSpecification.hasCategories(categoryEntities));

        Pageable pageable = PageRequest.of(pageNumber, paginationSize);
        Page<ArticleEntity> articles = articleJPARepository.findAll(spec, pageable);

        return articles.getContent().stream().map(art -> articleEntityMapper.toArticle(art)).toList();
    }

    @Override
    public Article getArticle(Integer id) {
        Optional<ArticleEntity> entity = articleJPARepository.findById(id);
        return entity.map(ArticleEntityMapper.INSTANCE::toArticle).orElse(null);
    }

    @Override
    public void deleteArticle(Integer articleId) {

        articleJPARepository.deleteById(articleId);
    }

    @Override
    public Article updateArticle(Integer id, Article article) {
        Optional<ArticleEntity> optionalEntity = articleJPARepository.findById(id);

        if (optionalEntity.isPresent()) {
            ArticleEntity articleEntity = optionalEntity.get();

            // Mise à jour des champs de l'article
            articleEntity.setName(article.getName());
            articleEntity.setBrand(article.getBrand());
            articleEntity.setPrice(article.getPrice());
            articleEntity.setEan(article.getEan());
            articleEntity.setVat((float) article.getVat());
            articleEntity.setImg(article.getImg());
            try {
                Iterable<CategoryEntity> entities = categoryJPARepository.findAllById(article.getCategories().stream().map(Category::getId).toList());
                articleEntity.setCategories((List<CategoryEntity>) entities);
            }catch (IllegalArgumentException e){
                throw new NotFoundException("One of the category sent is not not found");
            }
            articleJPARepository.save(articleEntity);
            return articleEntityMapper.toArticle(articleEntity);
        } else {
            throw new NotFoundException("Article with id " + id + " not found");
        }
    }

    public Article addArticle(Article article, int quantity) {
        ArticleEntity articleEntity = articleEntityMapper.toArticleEntity(article);
        ArticleEntity articleSaved = articleJPARepository.save(articleEntity);
        if (articleSaved == null)
            return null;

        StockEntity stockEntity = new StockEntity();
        stockEntity.setQuantity(quantity);
        stockEntity.setArticle(articleSaved);
        StockEntity stockSaved = stockJPARepository.save(stockEntity);

        if (stockSaved == null)
            return null;
        return articleEntityMapper.toArticle(articleSaved);
    }
}
