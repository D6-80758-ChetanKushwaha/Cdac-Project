package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dtos.SellerDTO;
import com.app.dtos.SigninDTO;
import com.app.entities.SellerEntity;
import com.app.repositories.SellerRepository;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{

	

	@Autowired
	private SellerRepository sdao;
	
	@Autowired
	public ModelMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public SellerDTO signup(@Valid SellerDTO sellerdto) {
		SellerEntity seller =  mapper.map(sellerdto, SellerEntity.class);
		seller.setPassword(passwordEncoder.encode(sellerdto.getPassword()));
		sdao.save(seller);
		return mapper.map(seller, SellerDTO.class);
	}
	
	@Override
	public SellerDTO signin(SigninDTO signinDto) {
		//SellerEntity seller = sdao.findByEmailAndPassword(signinDto.getEmail(), signinDto.getPassword()).orElseThrow();
		SellerEntity seller = sdao.findByEmail(signinDto.getEmail()).orElseThrow();

		return mapper.map(seller, SellerDTO.class);
	}
	
	@Override
	public List<SellerDTO> getAllSellers() {
		//List<SellerEntity> seller=sdao.findAll();
		//SellerDTO s = mapper.map(seller.get(0), SellerDTO.class);
		//List<SellerDTO> list = seller.stream().map(m -> mapper.map(m, SellerDTO.class)).collect(Collectors.toList());
		return sdao.findAll()
				.stream() //Stream<Dept>
				.map(seller -> mapper.map(seller,SellerDTO.class)) //Stream <DTO>
				.collect(Collectors.toList());//List<DTO>	
				
//		return list;
	}


	

	@Override
	public SellerDTO updateProfile(Long id, SellerDTO sdto) {
		SellerEntity seller = sdao.findById(id).orElseThrow(null);
		seller.setFirstName(sdto.getFirstName());
		seller.setLastName(sdto.getLastName());
		seller.setEmail(sdto.getEmail());
		seller.setPassword(sdto.getPassword());
		seller.setContactInfo(sdto.getContactInfo());
		seller.setAddress(sdto.getAddress());
		seller.setStatus(sdto.getStatus());
		sdao.save(seller);
		SellerDTO sellerdto = mapper.map(seller, SellerDTO.class);
		return sellerdto;
	

	}
	
	
}