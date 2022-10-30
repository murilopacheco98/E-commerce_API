package com.ecommerce.educative.dto;

import javax.validation.constraints.NotBlank;

public class ProductDto {

    private Integer id;
    private @NotBlank String name;
    private @NotBlank String imageURL;
    private @NotBlank Double price;
    private @NotBlank String description;
    private @NotBlank Integer categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageUrl(String imageURL) {
        this.imageURL = imageURL;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
