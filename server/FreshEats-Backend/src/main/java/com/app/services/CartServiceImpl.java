package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.ApiResponse;
import com.app.dtos.AddToCartDTO;
import com.app.dtos.CartProductDTO;
import com.app.dtos.ProductDTO;
import com.app.entities.CartEntity;
import com.app.entities.CartProductEntity;
import com.app.entities.CartStatus;
import com.app.entities.CustomerEntity;
import com.app.entities.ProductEntity;
import com.app.repositories.CartProductRepository;
import com.app.repositories.CartRepository;
import com.app.repositories.CustomerRepository;
import com.app.repositories.ProductRepository;



@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository custRepository;

	@Autowired
	private CartProductRepository cartProductRepository;

	@Autowired
	private ModelMapper mapper;

	// static {
	// cartRepository.save(new CartEntity());
	// }

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ApiResponse addProductToCart(AddToCartDTO cart) {

		// Check if any active cart is present
		CartEntity activeCart = getActiveCart(cart.getCustId());

		// Add Product
		// Check if product exsits
		Optional<CartProductEntity> existingCartProduct = cartProductRepository
				.findByCartIdAndProductId(activeCart.getId(), cart.getProdId());
		CartProductEntity newOrUpdateCartProduct = null;

		if (existingCartProduct != null && existingCartProduct.isPresent()) {
			newOrUpdateCartProduct = existingCartProduct.get();
			newOrUpdateCartProduct.setPrice(cart.getPrice());
			newOrUpdateCartProduct.setQuantity(cart.getQty());
		} else {
			ProductEntity productEntity = productRepository.findById(cart.getProdId())
					.orElseThrow(EntityNotFoundException::new);

			newOrUpdateCartProduct = CartProductEntity.builder()
					.cart(activeCart)
					.product(productEntity)
					.price(cart.getPrice())
					.quantity(cart.getQty())
					.build();
		}

		cartProductRepository.save(newOrUpdateCartProduct);

		return new ApiResponse("Cart Updated!!", true);
	}

	@Override
	public List<CartProductDTO> getCartProducts(long customerId) {
		CartEntity activeCart = getActiveCart(customerId);

		List<CartProductEntity> cartProducts = cartProductRepository.findByCartId(activeCart.getId());
		return cartProducts.stream().map(x -> mapper.map(x, CartProductDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeProductFromCart(Long customerId, Long productId) {
		CartEntity activeCart = getActiveCart(customerId);
		Optional<CartProductEntity> existingProduct = cartProductRepository.findByCartIdAndProductId(activeCart.getId(),
				productId);
		if (existingProduct == null || !existingProduct.isPresent()) {
			return new ApiResponse("Product Not Present In Cart!", true);
		}

		cartProductRepository.deleteById(existingProduct.get().getId());

		return new ApiResponse("Product Removed Successfully!", true);
	}

	private CartEntity getActiveCart(long customerId) {
		CartEntity activeCart;
		Optional<CartEntity> existingCart = cartRepository.findByCustomerIdAndCartStatus(customerId,
				CartStatus.ACTIVE);
		if (existingCart == null || !existingCart.isPresent()) {
			CustomerEntity customer = custRepository.findById(customerId)
					.orElseThrow(EntityNotFoundException::new);

			CartEntity newCart = CartEntity.builder()
					.customer(customer)
					.cartStatus(CartStatus.ACTIVE)
					.build();
			activeCart = cartRepository.save(newCart);
		} else {
			activeCart = existingCart.get();
		}

		return activeCart;
	}
}

//
// public void removeProductFromCart(Long cartId, Long productId) {
// CartEntity cart = cartRepository.findById(cartId)
// .orElseThrow();
// //orElseThrow(() -> new CartNotFoundException("Cart not found with id: " +
// cartId));
//
// ProductEntity product = productRepository.findById(productId)
// .orElseThrow();
// //orElseThrow(() -> new ProductNotFoundException("Product not found with id:
// " + productId));
//
// cart.removeProduct(product);
// cartRepository.save(cart);
// }
//
// public CartDTO getCart(Long cartId) {
// CartEntity cart = cartRepository.findById(cartId)
// .orElseThrow();
// //orElseThrow(() -> new CartNotFoundException("Cart not found with id: " +
// cartId));
//
// return new CartDTO(cart);
//
// }
//
// public double calculateTotalPrice(Long cartId) {
// CartEntity cart = cartRepository.findById(cartId)
// .orElseThrow();
// //orElseThrow(() -> new CartNotFoundException("Cart not found with id: " +
// cartId));
//
// double totalPrice = 0.0;
// for (ProductEntity product : cart.getProducts()) {
// totalPrice += product.getProductPrice();
// }
// return totalPrice;
// }

// @Override
// public void addProductToCart(Long userId, Long productId) {
// CartEntity cart = cartRepository.findById(userId)
// .orElseGet(() -> {
// CustomerEntity user = new CustomerEntity();
// user.setId(userId);
// CartEntity newCart = new CartEntity();
// newCart.setUser(user);
// return newCart;
// });
//
// // Retrieve the product
// ProductEntity product = productRepository.findById(productId)
// .orElseThrow(() -> new RuntimeException("Product not found"));
//
// // Add the product to the cart
// cart.getProducts().add(product);
//
// // Update the cart in the database
// cartRepository.save(cart);
// }
//
// }
