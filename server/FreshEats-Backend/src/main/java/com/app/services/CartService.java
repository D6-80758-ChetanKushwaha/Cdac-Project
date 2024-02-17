package com.app.services;

import java.util.List;

import com.app.entities.CartEntity;

public interface CartService {

	CartEntity saveCart(CartEntity obj);

	List<CartEntity> getAllCart();

	CartEntity getCartById(int id);

	void deleteCart(int id);

	CartEntity updateCart(CartEntity c, int id);

	List<CartEntity> findProdByCustID(int cid);

	int UpdateQty(int QT, int cid);

	int DeletecartByCustID(int cid);
}
