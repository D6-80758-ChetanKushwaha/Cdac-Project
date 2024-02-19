package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.app.entities.OrderEntity.OrderEntityBuilder;

import com.app.dtos.OrderCustomerDTO;
import com.app.dtos.OrderDTO;
import com.app.dtos.OrderProductDTO;
import com.app.dtos.OrderRequest;
import com.app.dtos.ProductDTO;
import com.app.dtos.SellerDTO;
import com.app.entities.CustomerEntity;
import com.app.entities.OrderCustomerEntity;
import com.app.entities.OrderEntity;
import com.app.entities.OrderProductEntity;
import com.app.entities.OrderStatus;
import com.app.entities.PaymentMethod;
import com.app.entities.PaymentStatus;
import com.app.entities.ProductEntity;
import com.app.entities.SellerEntity;

import com.app.repositories.CustomerRepository;
import com.app.repositories.OrderProductRepository;
import com.app.repositories.OrderRepository;
import com.app.repositories.ProductRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository odao;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderProductRepository orderProductRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<OrderDTO> getAllOrders() {
		List<OrderEntity> orders = odao.findAll();
		return orders// Sort.by(Direction.DESC, "order_date")
				.stream() // Stream<Dept>
				.map(order -> mapper.map(order, OrderDTO.class)) // Stream <DTO>
				.collect(Collectors.toList());// List<DTO>

	}

	public List<OrderDTO> getAllCustomerOrders(long customerId) {
		return odao.findByCustomerId(customerId)
				.stream()
				.map(order -> mapper.map(order, OrderDTO.class)) // Stream <DTO>
				.collect(Collectors.toList());
	}

	@Override
	public OrderDTO getOrderById(Long id) {
		OrderEntity orderEntity = odao.findById(id).orElseThrow(EntityNotFoundException::new);
		return mapper.map(orderEntity, OrderDTO.class);
	}

	@Transactional
	@Override
	public OrderDTO saveOrder(OrderRequest order) {
		OrderEntityBuilder orderBuilder = OrderEntity.builder();

		// Add Customer Details
		CustomerEntity customer = customerRepository.findById(order.getCustomerId())
				.orElseThrow(EntityNotFoundException::new);
		OrderCustomerEntity orderCustomer = OrderCustomerEntity.builder()
				.customerId(customer.getId())
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.username(customer.getUsername())
				.email(customer.getEmail())
				.address(customer.getAddress())
				.role(customer.getRole())
				.build();

		orderBuilder.customer(orderCustomer);

		orderBuilder.orderDate(order.getOrderDate());
		orderBuilder.shippingAddress(order.getShippingAddress());
		orderBuilder.paymentMethod(PaymentMethod.CASH);
		orderBuilder.paymentStatus(PaymentStatus.PENDING);
		orderBuilder.status(OrderStatus.PLACED);
		orderBuilder.totalPrice(order.getTotalPrice());

		OrderEntity savedOrder = odao.save(orderBuilder.build());

		// Get All products
		List<Long> prodIds = order.getProducts().stream().map(x -> x.getProductId()).collect(Collectors.toList());
		List<ProductEntity> products = productRepository.findAllById(prodIds);

		// Add All Products
		List<OrderProductEntity> orderProductEntities = new ArrayList<OrderProductEntity>();
		for (OrderProductDTO orderProductDTO : order.getProducts()) {

			// find product
			ProductEntity product = null;
			for (ProductEntity oe : products) {
				if (oe.getId() == orderProductDTO.getProductId()) {
					product = oe;
					break;
				}
			}
			if (product == null) {
				throw new EntityNotFoundException("Some Product Details not found!");
			}

			if (product.getStockQuantity() < orderProductDTO.getQuantity()) {
				throw new RuntimeException("Some Products are not available");
			}

			SellerEntity seller = product.getSeller();

			OrderProductEntity orderProductEntity = OrderProductEntity.builder()
					.productId(product.getId())
					.name(product.getName())
					.description(product.getProductDescription())
					.sellerId(seller != null ? seller.getId() : 0)
					.sellerName(seller != null ? seller.getFirstName() + " " + seller.getLastName() : null)
					.sellerEmail(seller != null ? seller.getEmail() : null)
					.quantity(orderProductDTO.getQuantity())
					.price(orderProductDTO.getPrice())
					.order(savedOrder)
					.build();

			orderProductEntities.add(orderProductEntity);
		}
		

		List<OrderProductEntity> savedProducts = orderProductRepository.saveAll(orderProductEntities);
		savedOrder.setProducts(savedProducts);

		
		// Update product quatities
		for (ProductEntity product : products) {
			OrderProductDTO orderProduct = null;
			for (OrderProductDTO orderProductDTO : order.getProducts()) {
				if(product.getId() == orderProductDTO.getProductId()) {
					orderProduct = orderProductDTO;
					break;
				}
			}

			product.setStockQuantity(product.getStockQuantity() - orderProduct.getQuantity());
		}

		productRepository.saveAll(products);

		return mapper.map(savedOrder, OrderDTO.class);
	}

	
	
//	orderby id
//	ststus change
//	save
//	qty

	@Override
	public boolean CancelOrder(Long orderId) {
		OrderEntity order = odao.findById(orderId).orElseThrow(EntityNotFoundException::new);
		order.setStatus(OrderStatus.CANCELLED);
		
		List<OrderProductEntity> products = order.getProducts();
		ProductEntity prod=new ProductEntity();
		
		for(OrderProductEntity orderProduct : products ) {
			 Long product = orderProduct.getProductId();
		        int quantity = orderProduct.getQuantity();
		        
		        // Update the quantity of the product
		        int updatedQuantity = prod.getStockQuantity() + quantity; 
		        prod.setStockQuantity(updatedQuantity);
		        
		        // Save the updated product back to the database
		        productRepository.save(prod);
		
		}
		odao.save(order);
		return true;
	}



}
