package com.ecommerce.educative.controller.cart;

import com.ecommerce.educative.common.ApiResponse;
import com.ecommerce.educative.dto.ProductDto;
import com.ecommerce.educative.model.cart.WishList;
import com.ecommerce.educative.model.product.Product;
import com.ecommerce.educative.model.user.UserEntity;
import com.ecommerce.educative.service.cart.WishListService;
import com.ecommerce.educative.service.user.AuthenticationService;

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
        UserEntity userEntity = authenticationService.getUserEntity(token);

        WishList wishList = new WishList(userEntity, product);
        wishListService.createWishList(wishList);

        ApiResponse apiResponse = new ApiResponse(true, "Add to wishlist");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) {
        authenticationService.authenticate(token);
        UserEntity userEntity = authenticationService.getUserEntity(token);

        List<ProductDto> productDtos = wishListService.getwWishListForUserEntity(userEntity);

        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
}
