package com.fil.sra.ports;

import java.util.List;

import com.fil.sra.dto.PerishableDto;

public interface IPerishableUseCase {

    List<PerishableDto> getExpiredPerishables();

}
