package com.fil.sra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fil.sra.dto.AddProductsCartCommand;
import com.fil.sra.dto.CartDto;
import com.fil.sra.ports.ICartUseCase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/client")
public class ClientController {

    private final ICartUseCase cartUseCase;

    public ClientController(ICartUseCase cartUseCase) {
        this.cartUseCase = cartUseCase;
    }

    @GetMapping("cart/{id}")
    public ResponseEntity<CartDto> getCart(@PathVariable Integer id) {
        try {
            log.info("Get cart");
            return ResponseEntity.ok(cartUseCase.getCart(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("cart/products/add")
    public ResponseEntity<CartDto> addProductsCart(@RequestBody AddProductsCartCommand command) {
        try {

            log.info("Add products to cart");
            return ResponseEntity.ok(cartUseCase.addProductsIntoCart(command.id(), command.productCarts()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
