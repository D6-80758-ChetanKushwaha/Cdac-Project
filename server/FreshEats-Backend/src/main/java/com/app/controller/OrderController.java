package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.OrderDTO;
import com.app.dtos.OrderRequest;
import com.app.dtos.ProductDTO;
import com.app.entities.OrderEntity;
import com.app.services.CartService;
import com.app.services.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin()
public class OrderController {

	@Autowired
	private OrderService manager;

	@Autowired 
	private CartService cartService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrder() {
		return new ResponseEntity<List<OrderDTO>>(manager.getAllOrders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
		return new ResponseEntity<OrderDTO>(manager.getOrderById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<OrderDTO> AddOrder(@RequestBody OrderRequest order) {
		OrderDTO savedProduct = manager.saveOrder(order);

		// Disable cart
		cartService.disableActiveCart(order.getCustomerId());

		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}



	@PutMapping("/{orderId}")
	public ResponseEntity<?> CancelOrder(@PathVariable Long orderId) {
		 return new ResponseEntity<>(manager.CancelOrder(orderId),HttpStatus.OK);
	
	
	}
	
	//cancel the order ...upadate status ...product quantity should revert

}
