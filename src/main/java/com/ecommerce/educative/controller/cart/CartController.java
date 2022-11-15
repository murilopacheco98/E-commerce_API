package com.ecommerce.educative.controller.cart;

import com.ecommerce.educative.common.ApiResponse;
import com.ecommerce.educative.dto.cart.AddToCartDto;
import com.ecommerce.educative.dto.cart.CartDto;
import com.ecommerce.educative.model.user.UserEntity;
import com.ecommerce.educative.service.cart.CartService;
import com.ecommerce.educative.service.user.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private AuthenticationService authenticationService;

    // post
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
            @RequestParam("token") String token) {
        authenticationService.authenticate(token);
        UserEntity userEntity = authenticationService.getUserEntity(token);
        cartService.addToCart(addToCartDto, userEntity);

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    // Get One
    @GetMapping("/cartUser")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
        authenticationService.authenticate(token);
        UserEntity userEntity = authenticationService.getUserEntity(token);

        CartDto cartDto = cartService.listCartItems(userEntity);
        return new ResponseEntity<>(cartDto, HttpStatus.FOUND);
    }

    // delete
    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Long cartItemId,
            @RequestParam("token") String token) {
        authenticationService.authenticate(token);
        UserEntity userEntity = authenticationService.getUserEntity(token);

        cartService.deleteCartItem(cartItemId, userEntity);

        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

    // Get All
    // @GetMapping("/")
    // public ResponseEntity<List<Cart>> getCartItems(@PathVariable("userId") Long userId,
    //         @RequestParam("token") String token) {

    //     authenticationService.authenticate(token)
                
    //     UserEntity userEntity = authenticationService.getUserEntity(token);

    //     List<Cart> cartDto = cartService.listCartAll();
    //     return new ResponseEntity<>(cartDto, HttpStatus.OK);
    // }
}
