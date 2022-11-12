package com.ecommerce.educative.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private @NotBlank String title;
    private @NotBlank String description;
    private @NotBlank String img;
    private @NotBlank Double price;
    private String size;
    private String color;
    private Long categoryId;

}
