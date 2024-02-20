package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.dtos.CustomerDTO;

public interface CustomerService {


	List<CustomerDTO> getAllCustomers();

	CustomerDTO getCustomerById(Long customerId);

	Optional<CustomerDTO> getCustomerByEmail(String email);

	CustomerDTO saveCustomer(CustomerDTO c);

	CustomerDTO update(Long id, CustomerDTO c);

	void deleteCustomer(Long id);

	int getPointsByID(Long cid);

	

}
