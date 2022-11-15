package com.ecommerce.educative.service.cart;

import com.ecommerce.educative.dto.ProductDto;
import com.ecommerce.educative.model.cart.WishList;
import com.ecommerce.educative.model.user.UserEntity;
import com.ecommerce.educative.repository.WishListRepository;
import com.ecommerce.educative.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ProductDto> getwWishListForUserEntity(UserEntity userEntity) {
        final List<WishList> wishLists = wishListRepository.findAllByUserEntityOrderByCreatedAtDesc(userEntity);
        List<ProductDto> productsDtos = new ArrayList<>();

        for (WishList wishList : wishLists) {
            productsDtos.add(productService.getProductDto(wishList.getProduct()));
        }

        return productsDtos;
    }
}
