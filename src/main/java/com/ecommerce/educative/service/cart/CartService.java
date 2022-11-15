package com.ecommerce.educative.service.cart;

import com.ecommerce.educative.dto.cart.AddToCartDto;
import com.ecommerce.educative.dto.cart.CartDto;
import com.ecommerce.educative.dto.cart.CartItemDto;
import com.ecommerce.educative.exception.customExceptions.BadRequestException;
import com.ecommerce.educative.model.cart.Cart;
import com.ecommerce.educative.model.product.Product;
import com.ecommerce.educative.model.user.UserEntity;
import com.ecommerce.educative.repository.CartRepository;
import com.ecommerce.educative.service.product.ProductService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    @Autowired
    CartRepository cartRepository;
    public void addToCart(AddToCartDto addToCartDto, UserEntity userEntity) {
        Product product = productService.findById(addToCartDto.getProductId());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUserEntity(userEntity);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedAt(new Date());

        cartRepository.save(cart);
    }

    public CartDto listCartItems(UserEntity userEntity) {
        List<Cart> cartList = cartRepository.findAllByUserEntityOrderByCreatedAt(userEntity);

        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart : cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cartItemDto.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto = new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);
        return cartDto;
    }

    public List<Cart> listCartAll() {
        List<Cart> cartList = cartRepository.findAll();
        return cartList;
    }

    public void deleteCartItem(Long cartItemId, UserEntity userEntity) {
        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
        if (optionalCart.isEmpty()) {
            throw new BadRequestException("cart item id is invalid " + cartItemId);
        }
        Cart cart = optionalCart.get();

        if (cart.getUserEntity() != userEntity) {
            throw new BadRequestException("cart item does not belong to this userEntity " + cartItemId);
        }

        cartRepository.delete(cart);
    }
}