package com.fourshark.dao;

import com.fourshark.model.CartModel;

public interface ICartDAO extends GenericDAO<CartModel>{
	public boolean insertProductIntoCart(long id);
	
	public boolean deleteProductFromCart(long id);
	
	
}
