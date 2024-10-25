package com.fil.sra.services;


import java.util.List;
import java.util.Date;

import com.fil.sra.dto.PerishableDto;
import com.fil.sra.exception.ResourceNotFoundException;
import com.fil.sra.mapper.PerishableDtoMapper;
import com.fil.sra.models.Perishable;
import com.fil.sra.ports.IPerishableRepository;
import com.fil.sra.ports.IPerishableUseCase;

public class PerishableUseCaseImpl implements IPerishableUseCase {

        private final IPerishableRepository perishableRepository;

        public PerishableUseCaseImpl(IPerishableRepository perishableRepository) {
            this.perishableRepository = perishableRepository;
        }

        @Override
        public List<PerishableDto> getExpiredPerishables() {

            Date currentDate = new Date();
            List<Perishable> perishables = perishableRepository.getExpiredPerishable(currentDate);
            if (perishables == null) {
                throw new ResourceNotFoundException( "No expired perishable found");
            }
            return perishables.stream().map(PerishableDtoMapper.INSTANCE::toPerishableDto).toList();
        }
}
