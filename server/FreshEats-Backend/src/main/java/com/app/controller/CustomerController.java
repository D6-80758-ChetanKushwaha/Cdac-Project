package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CustomerDTO;
import com.app.services.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers()
	{
		return new ResponseEntity<List<CustomerDTO>>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/{CustomerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long CustomerId )
	{
		return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(CustomerId),HttpStatus.OK);
	}
	
	@GetMapping("/byEmail/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
        Optional<CustomerDTO> customer = customerService.getCustomerByEmail(email);
        
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PostMapping
	public  ResponseEntity<CustomerDTO>AddCustomer(@RequestBody CustomerDTO c)
	{
		return new ResponseEntity<CustomerDTO>(customerService.saveCustomer(c),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> EditCustomer(@PathVariable Long id,@RequestBody CustomerDTO c )
	{
		return new ResponseEntity<CustomerDTO>(customerService.update(id,c),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{Customerid}")
	public void deleteCustomer(@PathVariable Long Customerid)
	{
		customerService.deleteCustomer(Customerid);
	}

	@GetMapping("/points/{cid}")
    public int getPointsByID(@PathVariable Long cid) {
        
        return customerService.getPointsByID(cid);
    }
}
