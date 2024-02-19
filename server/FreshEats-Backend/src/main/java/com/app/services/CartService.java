package com.app.services;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.AddToCartDTO;
import com.app.dtos.CartProductDTO;

public interface CartService {

	// void addProductToCart(Long cartId, int quantity);

	ApiResponse removeProductFromCart(Long customerId, Long productId);
	//
	// CartDTO getCart(Long cartId);
	//
	// double calculateTotalPrice(Long cartId);

	// void addProductToCart(Long userId, Long productId);

	ApiResponse addProductToCart(AddToCartDTO cart); // response DTO if needed

	List<CartProductDTO> getCartProducts(long customerId);

	boolean disableActiveCart(long customerId);

}
