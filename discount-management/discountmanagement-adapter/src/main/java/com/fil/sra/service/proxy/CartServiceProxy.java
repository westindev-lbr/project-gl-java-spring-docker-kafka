package com.fil.sra.service.proxy;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fil.sra.bdd.mapper.DataMapper;
import com.fil.sra.model.Cart;
import com.fil.sra.ports.ICartServiceProxy;
import com.fil.sra.service.data.CartData;
import com.fil.sra.service.dto.CartDto;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.Access;
import lombok.Data;

@Service
public class CartServiceProxy extends Proxy implements ICartServiceProxy {

    private String apiUrl;

    public CartServiceProxy(RestTemplate rest) {
        super(rest);
    }

    public Cart addProductToCart(Cart cart) {
        String urlRequest = apiUrl + "/cart/add";
        CartData fetchedData = super.postTemplate(urlRequest, CartData.class, DataMapper.INSTANCE.toCartData(cart));
        return DataMapper.INSTANCE.toCart(fetchedData);
    }

    @Override
    public Cart getCart(Integer id) {
        String urlRequest = apiUrl + "/cart/" + id;
        CartData fetchedData = super.getTemplate(urlRequest, CartData.class);
        return DataMapper.INSTANCE.toCart(fetchedData);
    }

    @Override
    public Cart updateCart(Cart cart) {
        String urlRequest = apiUrl + "/cart/update";
        CartData fetchedData = super.putTemplate(urlRequest, CartData.class, DataMapper.INSTANCE.toCartData(cart));
        return DataMapper.INSTANCE.toCart(fetchedData);
    }
}
