package com.fourshark.service.impl;

import javax.inject.Inject;

import com.fourshark.dao.ICartDAO;
import com.fourshark.model.CartModel;
import com.fourshark.model.ProductModel;
import com.fourshark.service.ICartService;

public class CartService implements ICartService {

	@Inject ICartDAO cartDAO;
	
	@Override
	public void insertCart(CartModel cart, ProductModel product, Integer quantity) {
		//cartDAO.insertCart(cart, product, quatity);
	}

}
