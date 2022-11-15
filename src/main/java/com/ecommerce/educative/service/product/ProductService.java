package com.ecommerce.educative.service.product;

import com.ecommerce.educative.dto.ProductDto;
import com.ecommerce.educative.exception.customExceptions.NotFoundException;
import com.ecommerce.educative.model.product.Category;
import com.ecommerce.educative.model.product.Product;
import com.ecommerce.educative.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        product.setImg(productDto.getImg());
        product.setTitle(productDto.getTitle());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setImg(product.getImg());
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

    public void updateProduct(ProductDto productDto, Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new NotFoundException("product not present");
        }
        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImg(productDto.getImg());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    public Product findById(Long productId) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById((productId));
        if (!optionalProduct.isPresent()) {
            throw new NotFoundException("product is invalid" + productId);
        }
        return optionalProduct.get();
    }
}
