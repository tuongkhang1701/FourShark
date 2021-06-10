package com.fourshark.dao.impl;

import java.util.ArrayList;

import javax.inject.Inject;

import com.fourshark.dao.ICartDAO;
import com.fourshark.dao.IProductDAO;
import com.fourshark.model.CartModel;
import com.fourshark.model.ProductModel;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO {

	@Inject
	private static IProductDAO productDAO;
	
	private static ArrayList<ProductModel> listProduct = productDAO.findAll();
	private static ArrayList<ProductModel> listCart = new ArrayList<>();
	
	public CartDAO() {
		for (int i = 0; i < listProduct.size(); i++) {
			listCart.add(listProduct.get(i));
		}
	}
	
	@Override
	public boolean insertProductIntoCart(long id) {
			for (int i = 0; i < listProduct.size(); i++) {
				if (listProduct.get(i).getId() == id) {
					listCart.add(listProduct.get(i));
					return true;
				}
			}
			return false;
		}

	@Override
	public boolean deleteProductFromCart(long id) {
		for (int i = 0; i < listCart.size(); i++) {
			if (listCart.get(i).getId() == id) {
				listCart.remove(i);
				return true;
			}
		}
		return false;
	}
}
