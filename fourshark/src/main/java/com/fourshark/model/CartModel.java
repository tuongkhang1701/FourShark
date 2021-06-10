package com.fourshark.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CartModel extends AbstractModel<CartModel>{
	private ProductModel product;
	private int quantity;
	private BigDecimal price;
	public CartModel() {
	}
	


	public CartModel(ProductModel product, int quantity, BigDecimal price, Timestamp date) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.setPrice(price);
		this.setCreatedDate(date);
	}



	public CartModel(ProductModel product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public ProductModel getProduct() {
		return product;
	}



	public void setProduct(ProductModel product) {
		this.product = product;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
