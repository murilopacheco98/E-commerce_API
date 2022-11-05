package com.ecommerce.educative.dto.cart;

import com.ecommerce.educative.model.Cart;
import com.ecommerce.educative.model.Product;

public class CartItemDto {
    private Long id;
    private Integer quantity;
    private Product product;

    public CartItemDto() {
    }

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.product = cart.getProduct();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
