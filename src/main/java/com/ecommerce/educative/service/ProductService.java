package com.ecommerce.educative.service;

import com.ecommerce.educative.Exceptions.ProductNotExistsException;
import com.ecommerce.educative.dto.ProductDto;
import com.ecommerce.educative.model.Category;
import com.ecommerce.educative.model.Product;
import com.ecommerce.educative.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setName(product.getName());
        productDto.setImageURL(product.getImageURL());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }
        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    public Product findById(Long productId) throws ProductNotExistsException {
        Optional<Product> optionalProduct = productRepository.findById(Math.toIntExact(productId));
        if (!optionalProduct.isPresent()) {
            throw new ProductNotExistsException("product is invalid" + productId);
        }
        return optionalProduct.get();
    }
}
