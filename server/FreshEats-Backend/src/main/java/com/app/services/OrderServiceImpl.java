package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OrderDTO;
import com.app.dtos.ProductDTO;
import com.app.dtos.SellerDTO;
import com.app.entities.OrderEntity;
import com.app.entities.ProductEntity;
import com.app.repositories.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository odao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<OrderDTO> getAllOrders() {
	
		return odao.findAll()
				.stream() //Stream<Dept>
				.map(order -> mapper.map(order,OrderDTO.class)) //Stream <DTO>
				.collect(Collectors.toList());//List<DTO>	
				
	}

	@Override
	public OrderDTO getOrderById(Long id) {
		OrderEntity orderEntity = odao.findById(id).orElseThrow();
		if(orderEntity != null) {
        return mapper.map(orderEntity, OrderDTO.class);
		}
		return null;
	}

	@Override
	public OrderDTO saveOrder(OrderDTO order) {
		OrderEntity orderEntity = mapper.map(order, OrderEntity.class);
		odao.save(orderEntity);
		return mapper.map(order, OrderDTO.class);
	}

//	@Override
//	public OrderDTO update(Long id, OrderDTO order) {
//		OrderEntity or = odao.findById(id).orElseThrow(null);
//		or.setTotalPrice(order.getTotalPrice());
//		or.setStatus(order.getStatus());
//		or.setPaymentMethod(order.getPaymentMethod());
//		or.setShippingAddress(order.getShippingAddress());
//		
//		odao.save(or);
//		OrderDTO orderdto = mapper.map(or, OrderDTO.class);
//		return orderdto;
//		
//	}

	@Override
	public void deleteOrder(Long id) {
		OrderEntity order = odao.findById(id).get();
		if(order != null) {
			odao.delete(order);
		}
	}

}
