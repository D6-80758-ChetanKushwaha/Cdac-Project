package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.CartEntity;
import com.app.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;

	// Insert
	public CartEntity saveCart(CartEntity obj) {
		return cartRepo.save(obj);
	}

	// SelectAll
	public List<CartEntity> getAllCart() {
		return cartRepo.findAll();
	}

	// SelectById
	public CartEntity getCartById(int id) {

		return cartRepo.findById(id).get();
	}

	// Delete
	public void deleteCart(int id) {

		CartEntity c = cartRepo.findById(id).get();

		if (c != null) {
			cartRepo.delete(c);
		}
	}

	// Update
	public CartEntity updateCart(CartEntity c, int id) {
		CartEntity oldc = cartRepo.findById(id).get();
		oldc.setQty(c.getQty());

		oldc.setQty(c.getProdID());
		oldc.setCustID(c.getCustID());
		return cartRepo.save(oldc);

	}

	public List<CartEntity> findProdByCustID(int cid) {
		return cartRepo.findProdByCustID(cid);
	}

	public int UpdateQty(int QT, int cid) {
		cartRepo.UpdateQty(QT, cid);
		return 1;
	}

	public int DeletecartByCustID(int cid) {
		cartRepo.DeletecartByCust(cid);
		return 1;
	}

}
