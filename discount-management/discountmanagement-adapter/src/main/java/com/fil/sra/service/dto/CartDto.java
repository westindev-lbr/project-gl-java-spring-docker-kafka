package com.fil.sra.service.dto;

import java.util.List;

public record CartDto(
        int id,
        int userId,
        List<ProductCartDto> products
) {

}
