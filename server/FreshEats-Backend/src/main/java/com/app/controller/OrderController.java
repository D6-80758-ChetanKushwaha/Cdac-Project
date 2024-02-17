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
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.OrderDTO;
import com.app.dtos.ProductDTO;
import com.app.entities.OrderEntity;
import com.app.services.OrderService;

@RestController
@RequestMapping("/api/Order")
@CrossOrigin()
public class OrderController {
	
	
	@Autowired
	private OrderService manager;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrder()
	{
		return new ResponseEntity<List<OrderDTO>>(manager.getAllOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id )
	{
		return new ResponseEntity<OrderDTO>(manager.getOrderById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<OrderDTO>AddOrder(@RequestBody OrderDTO order)
	{
		OrderDTO savedProduct = manager.saveOrder(order);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<OrderDTO> EditOrder(@PathVariable Long id, @RequestBody OrderDTO order )
//	{
//		return new ResponseEntity<OrderDTO>(manager.update(id, order),HttpStatus.CREATED);
//	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id)
	{
		manager.deleteOrder(id);
	}

}
