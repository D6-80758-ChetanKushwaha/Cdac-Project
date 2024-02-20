package com.app.services;

import java.util.List;

import com.app.dtos.OrderDTO;
import com.app.dtos.OrderRequest;


public interface OrderService {

	List<OrderDTO> getAllOrders();

	OrderDTO getOrderById(Long id);

	OrderDTO saveOrder(OrderRequest order);

	//OrderDTO update(Long id, OrderDTO order);


	boolean CancelOrder(Long orderId);



	

}
