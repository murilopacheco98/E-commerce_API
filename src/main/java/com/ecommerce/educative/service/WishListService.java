package com.ecommerce.educative.service;

import com.ecommerce.educative.model.WishList;
import com.ecommerce.educative.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;

    public void createWishList(WishList wishList) {
        wishListRepository.save(wishList);
    }
}
