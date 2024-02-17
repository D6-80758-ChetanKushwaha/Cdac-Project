package com.app.services;

import java.util.List;

import com.app.dtos.OrderDTO;


public interface OrderService {

	List<OrderDTO> getAllOrders();

	OrderDTO getOrderById(Long id);

	OrderDTO saveOrder(OrderDTO order);

	//OrderDTO update(Long id, OrderDTO order);

	void deleteOrder(Long id);



	

}
