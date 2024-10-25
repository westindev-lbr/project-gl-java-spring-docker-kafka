package com.fil.sra.bdd.repository;

import com.fil.sra.bdd.entity.ArticleEntity;
import com.fil.sra.bdd.entity.PerishableEntity;
import com.fil.sra.bdd.mapper.PerishableEntityMapper;
import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.models.Perishable;

import com.fil.sra.ports.IPerishableRepository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PerishableRepositoryImpl implements IPerishableRepository {

    private final PerishableJPARepository perishableJPARepository;

    public PerishableRepositoryImpl(PerishableJPARepository perishableJPARepository){
        this.perishableJPARepository = perishableJPARepository;
    }

    @Override
    public Perishable getPerishable(Integer id) {
        return this.perishableJPARepository.findById(id).map(PerishableEntityMapper.INSTANCE::toPerishable).orElse(null);
    }

    @Override
    public Perishable addPerishable(Perishable perishable) {
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
    public List<Perishable> getExpiredPerishable(Date currentDate) {
        List<PerishableEntity> perishables = this.perishableJPARepository.findByBestBeforeBefore(currentDate);
        return perishables.stream().map(PerishableEntityMapper.INSTANCE::toPerishable).toList();
    }

    @Override
    public Perishable getPerishableByEan(String ean) {
        return this.perishableJPARepository.findByEan(ean).map(PerishableEntityMapper.INSTANCE::toPerishable).orElseThrow(() -> new ResourceNotFoundException("Perishable not found"));
    }
}
