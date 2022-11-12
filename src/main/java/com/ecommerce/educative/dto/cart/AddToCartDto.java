package com.ecommerce.educative.dto.cart;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddToCartDto {

    private Long id;
    private @NotNull Long productId;
    private @NotNull Double quantity;

}
