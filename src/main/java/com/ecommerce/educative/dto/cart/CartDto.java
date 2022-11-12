package com.ecommerce.educative.dto.cart;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDto {
    List<CartItemDto> cartItems;
    private double totalCost;

}
