package com.ecommerce.educative.service;

import com.ecommerce.educative.dto.ProductDto;
import com.ecommerce.educative.model.User;
import com.ecommerce.educative.model.WishList;
import com.ecommerce.educative.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;
    @Autowired
    ProductService productService;

    public void createWishList(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<ProductDto> getwWishLishForUser(User user) {
        final List<WishList> wishLists = wishListRepository.findAllByUserOrderByCreatedAtDesc(user);
        List<ProductDto> productsDtos = new ArrayList<>();

        for (WishList wishList : wishLists) {
            productsDtos.add(productService.getProductDto(wishList.getProduct()));
        }

        return productsDtos;
    }
}
