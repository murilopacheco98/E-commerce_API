package com.ecommerce.educative.dto.checkout;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckoutItemDto {

    private String productName;
    private int quantity;
    private double price;
    private long productId;
    private long userId;

}
