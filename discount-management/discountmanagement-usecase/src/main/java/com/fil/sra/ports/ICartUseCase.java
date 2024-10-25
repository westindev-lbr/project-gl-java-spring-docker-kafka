package com.fil.sra.ports;

import java.util.List;

import com.fil.sra.dto.CartDto;
import com.fil.sra.dto.ProductCartDto;
import com.fil.sra.model.Cart;

public interface ICartUseCase {
    CartDto addCart(Cart cart);
    CartDto addProductsIntoCart(Integer id, List<ProductCartDto> productsCart);
    CartDto getCart(Integer id);
    CartDto updateCart(Cart cart);
    void deleteCart(Integer id);
}
