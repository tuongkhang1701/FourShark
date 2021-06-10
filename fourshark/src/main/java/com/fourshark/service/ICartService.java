package com.fourshark.service;

import com.fourshark.model.CartModel;
import com.fourshark.model.ProductModel;

public interface ICartService {
	void insertCart(CartModel cart, ProductModel product, Integer quantity);
}
