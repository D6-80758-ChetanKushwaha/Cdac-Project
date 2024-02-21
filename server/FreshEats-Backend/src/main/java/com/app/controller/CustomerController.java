package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dtos.CustomerDTO;
import com.app.exceptions.CustomerControllerException;
import com.app.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		try {
			return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
		} catch (Exception e) {
			throw new CustomerControllerException("Error retrieving all customers", e);
		}
	}

	@GetMapping("/{CustomerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long CustomerId) {
		try {
			return new ResponseEntity<>(customerService.getCustomerById(CustomerId), HttpStatus.OK);
		} catch (Exception e) {
			throw new CustomerControllerException("Error retrieving customer by ID", e);
		}
	}

	@GetMapping("/byEmail/{email}")
	public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
		try {
			Optional<CustomerDTO> customer = customerService.getCustomerByEmail(email);
			return customer.map(value -> ResponseEntity.ok(value))
					.orElseThrow(() -> new CustomerControllerException("Customer not found for email: " + email));
		} catch (Exception e) {
			throw new CustomerControllerException("Error retrieving customer by given email", e);
		}
	}

	@PostMapping
	public ResponseEntity<CustomerDTO> AddCustomer(@RequestBody CustomerDTO c) {
		try {
			return new ResponseEntity<>(customerService.saveCustomer(c), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomerControllerException("Error adding customer ", e);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> EditCustomer(@PathVariable Long id, @RequestBody CustomerDTO c) {
		try {
			return new ResponseEntity<>(customerService.update(id, c), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomerControllerException("Error updating customer by given id ", e);
		}
	}

	@DeleteMapping("/{Customerid}")
	public void deleteCustomer(@PathVariable Long Customerid) {
		try {
			customerService.deleteCustomer(Customerid);
		} catch (Exception e) {
			throw new CustomerControllerException("Error deleting customer by given customer id", e);
		}
	}

	@GetMapping("/points/{cid}")
	public int getPointsByID(@PathVariable Long cid) {
		try {
			return customerService.getPointsByID(cid);
		} catch (Exception e) {
			throw new CustomerControllerException("Error retrieving customer points by given cid", e);
		}
	}

	@ExceptionHandler(CustomerControllerException.class)
	public ResponseEntity<String> handleCustomException(CustomerControllerException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
