package com.fil.sra.usecase;

import java.util.List;

import com.fil.sra.dto.CartDto;
import com.fil.sra.dto.ProductCartDto;
import com.fil.sra.exception.RessourceNotFoundException;
import com.fil.sra.mapper.CartDtoMapper;
import com.fil.sra.mapper.ProductCartDtoMapper;
import com.fil.sra.model.Cart;
import com.fil.sra.model.ProductCart;
import com.fil.sra.ports.ICartServiceProxy;
import com.fil.sra.ports.ICartUseCase;

public class CartUseCaseImpl implements ICartUseCase {

    private final ICartServiceProxy cartServiceProxy;

    public CartUseCaseImpl(ICartServiceProxy cartServiceProxy) {
        this.cartServiceProxy = cartServiceProxy;
    }

    @Override
    public CartDto addProductsIntoCart(Integer id, List<ProductCartDto> productCarts) {
        Cart cart = cartServiceProxy.getCart(id);
        List<ProductCart> productsToAdd = productCarts
                .stream()
                .map(ProductCartDtoMapper.INSTANCE::productCartDtotoModel)
                .toList();
        cart.getProductsCart().addAll(productsToAdd);
        Cart updatedCart = cartServiceProxy.updateCart(cart);
        return CartDtoMapper.INSTANCE.carttoDto(updatedCart);
    }

    @Override
    public void deleteCart(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCart'");
    }

    @Override
    public CartDto addCart(Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCart'");
    }

    @Override
    public CartDto getCart(Integer id) {
        try {
            Cart cart = cartServiceProxy.getCart(id);
            return CartDtoMapper.INSTANCE.carttoDto(cart);
        } catch (Exception e) {
            throw new RessourceNotFoundException("Cart not found");
        }
    }

    @Override
    public CartDto updateCart(Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCart'");
    }

}
