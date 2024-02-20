package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dtos.AddToCartDTO;
import com.app.dtos.ApiResponse;
import com.app.dtos.CartProductDTO;
import com.app.entities.CartEntity;
import com.app.services.CartService;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/addProduct")
	public ResponseEntity<?> addProductToCart(@RequestBody AddToCartDTO cart) {

		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(cartService.addProductToCart(cart));

	}

	// get all my orders on the cart -> return list of products
	// product name, Qty, prize per unit, total prize(Qty * prize)

	@GetMapping("/getProduct/{customerId}")
	public List<CartProductDTO> getProducts(@PathVariable long customerId) {
		return cartService.getCartProducts(customerId);
	}

	@DeleteMapping("/{customerId}/removeProduct/{productId}")
	public ResponseEntity<ApiResponse> removeProductFromCart(@PathVariable Long customerId,
			@PathVariable Long productId) {
		return ResponseEntity.ok(cartService.removeProductFromCart(customerId, productId));
	}
	
	//Calculation of total price -->frontend work

}
