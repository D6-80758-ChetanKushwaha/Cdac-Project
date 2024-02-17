package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dtos.SellerDTO;
import com.app.dtos.SigninDTO;

public interface SellerService {

	public List<SellerDTO> getAllSellers();

	public SellerDTO signin(SigninDTO signinDto); 
	
	public SellerDTO signup(@Valid SellerDTO sellerdto);

	public SellerDTO updateProfile(Long id, SellerDTO sdto);
	
}
