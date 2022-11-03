package com.ecommerce.educative.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "category_name")
    private @NotBlank String CategoryName;

    private @NotBlank String Description;

    @Column(name = "image_url")
    private @NotBlank String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(CategoryName, category.CategoryName) && Objects.equals(Description, category.Description) && Objects.equals(imageUrl, category.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CategoryName, Description, imageUrl);
    }
}
