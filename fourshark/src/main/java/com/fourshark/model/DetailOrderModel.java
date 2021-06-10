package com.fourshark.model;

import java.math.BigDecimal;

public class DetailOrderModel extends AbstractModel<DetailOrderModel>{
	private ProductModel product;
	private String email;
	private OrderModel order;

	private int quantity;
	private BigDecimal price;

	public DetailOrderModel() {
		// TODO Auto-generated constructor stub
	}

	public DetailOrderModel(ProductModel product, OrderModel order, int quantity, String email, BigDecimal price) {
		this.product = product;
		this.email = email;
		this.order = order;
		this.quantity = quantity;
		this.setPrice(price);
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public OrderModel getOrder() {
		return order;
	}
	public void setOrder(OrderModel order) {
		this.order = order;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
