package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.CategoryEntity;
import com.fil.sra.bdd.entity.StockEntity;
import com.fil.sra.bdd.mapper.ArticleEntityMapper;
import com.fil.sra.bdd.mapper.CategoryEntityMapper;
import com.fil.sra.bdd.mapper.StockEntityMapper;
import com.fil.sra.bdd.repository.ArticleJPARepository;
import com.fil.sra.bdd.repository.CategoryJPARepository;
import com.fil.sra.bdd.specification.ArticleSpecification;
import com.fil.sra.exception.CategoryNotFoundException;
import com.fil.sra.models.Article;
import com.fil.sra.ports.IArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
    public List<Article> getArticlesByCriteria(String ean, String subName, List<String> categories, int paginationSize,
            int pageNumber) throws CategoryNotFoundException {

        List<CategoryEntity> categoryEntities = new ArrayList<>();

        // On lève une erreur si une des catégories n'existe pas
        if (categories != null && !categories.isEmpty()) {
            categoryEntities = categories.stream().map(name -> {
                Optional<CategoryEntity> entity = categoryJPARepository.findByName(name);
                if (!entity.isPresent()) {
                    throw new CategoryNotFoundException("Category " + name + " not found");
                }
                return entity.get();
            }).toList();
        }

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
    public Article updateArticle(Article article) {
        Optional<ArticleEntity> optionalEntity = articleJPARepository.findById(article.getId());

        if (optionalEntity.isPresent()) {
            ArticleEntity entity = optionalEntity.get();

            // Parcours des champs de l'objet Article
            for (Field field : Article.class.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(article); // Récupère la valeur du champ dans l'objet Article
                    if (value != null) {
                        Field entityField = ArticleEntity.class.getDeclaredField(field.getName());
                        entityField.setAccessible(true);
                        if (field.getName().equals("categories")) { // Gestion spéciale pour la relation CategoryEntity
                            if (article.getCategories() != null) {
                                List<CategoryEntity> categoryEntities = article.getCategories().stream()
                                        .map(cat -> categoryJPARepository.findById(cat.getId())
                                                .orElse(CategoryEntityMapper.INSTANCE.toCategoryEntity(cat)))
                                        .toList();
                                categoryJPARepository.saveAll(categoryEntities);
                                entityField.set(entity, categoryEntities);
                            }
                        } else {
                            entityField.set(entity, value);
                        }
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException("Error during article updating : " + e.getMessage());
                }
            }
            ArticleEntity updatedEntity = articleJPARepository.save(entity);
            return ArticleEntityMapper.INSTANCE.toArticle(updatedEntity);
        }
        return null;
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
