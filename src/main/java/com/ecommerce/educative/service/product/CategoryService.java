package com.ecommerce.educative.service.product;

import com.ecommerce.educative.model.product.Category;
import com.ecommerce.educative.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryService {
    @Autowired
     private CategoryRepository categoryRepo;

    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> listCategory() {
        return categoryRepo.findAll();
    }

    public void updateCategory(long categoryId, Category updateCategory) {
        Category category = categoryRepo.getReferenceById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepo.save(category);
    }

    public boolean findById(long categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }
}
