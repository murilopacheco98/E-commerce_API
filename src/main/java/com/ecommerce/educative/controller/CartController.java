package com.ecommerce.educative.controller;

import com.ecommerce.educative.common.ApiResponse;
import com.ecommerce.educative.dto.cart.AddToCartDto;
import com.ecommerce.educative.dto.cart.CartDto;
import com.ecommerce.educative.model.Product;
import com.ecommerce.educative.model.User;
import com.ecommerce.educative.service.AuthenticationService;
import com.ecommerce.educative.service.CartService;
import com.ecommerce.educative.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private AuthenticationService authenticationService;

    //post
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.addToCart(addToCartDto, user);

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    //get
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto, HttpStatus.FOUND);
    }
    //delete
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Long cartItemId, @RequestParam("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        cartService.deleteCartItem(cartItemId, user);

        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
}
