package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.SellerDTO;
import com.app.dtos.SigninDTO;
import com.app.dtos.SigninResponse;
import com.app.security.JwtUtils;
import com.app.services.SellerService;

@RestController
@RequestMapping("/api/seller")
public class SellerController {
	
	@Autowired
	private SellerService sservice;
	
	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private AuthenticationManager mgr;
	
	@PostMapping("/signup")
	public ResponseEntity<SellerDTO> signup(@RequestBody @Valid SellerDTO sellerdto) {
		System.out.println(sellerdto);
		return new ResponseEntity<SellerDTO>(sservice.signup(sellerdto), HttpStatus.CREATED); 
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid SigninDTO reqDTO) {
		System.out.println("in signin " + reqDTO);
		// simply invoke authentucate(...) on AuthMgr
		// i/p : Authentication => un verifed credentials
		// i/f --> Authentication --> imple by UsernamePasswordAuthToken
		// throws exc OR rets : verified credentials (UserDetails i.pl class: custom
		// user details)

		Authentication verifiedAuth = mgr
				.authenticate(new UsernamePasswordAuthenticationToken
						(reqDTO.getEmail(), reqDTO.getPassword()));
		System.out.println(verifiedAuth.getClass());// Custom user details
		// => auth success
		return ResponseEntity
				.ok(new SigninResponse(utils.generateJwtToken(verifiedAuth), "Successful Authentication!!!"));

	}
	
	@GetMapping("/get")
	public ResponseEntity<List<SellerDTO>> getAllSellers() {
		System.out.println("all users");
		return new ResponseEntity<List<SellerDTO>>(sservice.getAllSellers(), HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public void logout() {
		
	}
	
	@PutMapping("/updateProfile/{id}")
	public ResponseEntity<SellerDTO> updateProfile(@PathVariable Long id, @RequestBody SellerDTO sdto) {
		return new ResponseEntity<SellerDTO>(sservice.updateProfile(id, sdto), HttpStatus.OK);
	}

}
