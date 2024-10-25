package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.PerishableEntity;
import com.fil.sra.bdd.mapper.PerishableEntityMapper;
import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.models.Perishable;
import com.fil.sra.ports.IArticleRepository;
import com.fil.sra.ports.IPerishableRepository;

import org.springframework.stereotype.Service;

@Service
public class PerishableRepositoryImpl implements IPerishableRepository {

    private final PerishableJPARepository perishableJPARepository;
    private final IArticleRepository articleRepository;

    public PerishableRepositoryImpl(IArticleRepository articleRepository,PerishableJPARepository perishableJPARepository){
        this.articleRepository = articleRepository;
        this.perishableJPARepository = perishableJPARepository;
    }

    @Override
    public Perishable getPerishable(Integer id) {
        return this.perishableJPARepository.findById(id).map(PerishableEntityMapper.INSTANCE::toPerishable).orElse(null);
    }

    @Override
    public Perishable createPerishable(Perishable perishable) {
        PerishableEntity entity = this.perishableJPARepository.save(PerishableEntityMapper.INSTANCE.toPerishableEntity(perishable));
        return PerishableEntityMapper.INSTANCE.toPerishable(entity);
    }

    @Override
    public Perishable updatePerishable(Perishable perishable) {
        return this.perishableJPARepository.findById(perishable.getId()).map( e -> {
            if(perishable.getBestBefore()!=null) e.setBestBefore(perishable.getBestBefore());
            if(perishable.getLot()!=null) e.setLot(perishable.getLot());
            return PerishableEntityMapper.INSTANCE.toPerishable(this.perishableJPARepository.save(e));
        }).orElse(null);
    }

    @Override
    public void deletePerishable(Integer id) {
        this.perishableJPARepository.deleteById(id);
    }

    @Override
    public Perishable getPerishableByEan(String ean) {
        return this.perishableJPARepository.findByEan(ean).map(PerishableEntityMapper.INSTANCE::toPerishable).orElseThrow(() -> new ResourceNotFoundException("Perishable not found"));
    }
}
