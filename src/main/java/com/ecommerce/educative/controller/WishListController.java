package com.ecommerce.educative.controller;

import com.ecommerce.educative.common.ApiResponse;
import com.ecommerce.educative.dto.ProductDto;
import com.ecommerce.educative.model.Product;
import com.ecommerce.educative.model.User;
import com.ecommerce.educative.model.WishList;
import com.ecommerce.educative.service.AuthenticationService;
import com.ecommerce.educative.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wishlist")
public class WishListController {

    @Autowired
    WishListService wishListService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToWishList(@RequestBody Product product, @RequestParam("token") String token ) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        WishList wishList = new WishList(user, product);
        wishListService.createWishList(wishList);

        ApiResponse apiResponse = new ApiResponse(true, "Add to wishlist");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        List<ProductDto> productDtos = wishListService.getwWishLishForUser(user);

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
}
