package com.fil.sra.ports;

import com.fil.sra.model.Cart;

public interface ICartServiceProxy {
    Cart getCart(Integer id);
    Cart updateCart(Cart cart);
}
