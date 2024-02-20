package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.CustomerDTO;
import com.app.entities.CustomerEntity;
import com.app.repositories.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository custdao;
	
	@Autowired
	public ModelMapper mapper;
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		return custdao.findAll()
				.stream() //Stream<Dept>
				.map(cust -> mapper.map(cust,CustomerDTO.class)) //Stream <DTO>
				.collect(Collectors.toList());//List<DTO>	
	}

	@Override
	public CustomerDTO getCustomerById(Long customerId) {
		CustomerEntity custEntity = custdao.findById(customerId).orElseThrow();
		if(custEntity != null) {
        return mapper.map(custEntity, CustomerDTO.class);
		}
		return null;
	}

	@Override
	public Optional<CustomerDTO> getCustomerByEmail(String email) {
		 return custdao.findByEmail(email)
	                .map(customerEntity -> mapper.map(customerEntity, CustomerDTO.class));
	    
	}

	@Override
	public CustomerDTO saveCustomer(CustomerDTO cdto) {
		CustomerEntity cust =  mapper.map(cdto, CustomerEntity.class);
		custdao.save(cust);
		return mapper.map(cust, CustomerDTO.class);
	}

	@Override
	public CustomerDTO update(Long id,CustomerDTO cdto) {
		CustomerEntity cust = custdao.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer with id " + id + " not found"));
		cust.setFirstName(cdto.getFirstName());
		cust.setLastName(cdto.getLastName());
		cust.setUsername(cdto.getUsername());
		cust.setEmail(cdto.getEmail());
		cust.setPassword(cdto.getPassword());
		cust.setAddress(cdto.getAddress());
		cust.setRole(cdto.getRole());
		custdao.save(cust);
		CustomerDTO custdto = mapper.map(cust, CustomerDTO.class);
		return custdto;
	}

	@Override
	public void deleteCustomer(Long id) {
		CustomerEntity cust = custdao.findById(id).get();
		if(cust != null) {
			custdao.delete(cust);
		}
	}

	@Override
	public int getPointsByID(Long cid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
