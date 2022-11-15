package com.ecommerce.educative.dto.cart;

import com.ecommerce.educative.model.cart.Cart;
import com.ecommerce.educative.model.product.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private Double quantity;
    private Product product;

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.product = cart.getProduct();
    }
}
