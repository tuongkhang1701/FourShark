package com.fourshark.model;

import java.sql.Timestamp;

public class OrderModel extends AbstractModel<OrderModel>{
	private String deliveryAddress;
	private PaymentModel paymentMethod;
	private UserModel user;
	private long[] ids;
	private String sortCreatedDate;
	private String sortBy;
	
	
	public OrderModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OrderModel(String deliveryAddress, PaymentModel paymentMethod, UserModel user) {
		super();
		this.deliveryAddress = deliveryAddress;
		this.paymentMethod = paymentMethod;
		this.user = user;
		this.setCreatedDate(new Timestamp(System.currentTimeMillis()));
	}


	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public PaymentModel getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentModel paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public String getSortCreatedDate() {
		return sortCreatedDate;
	}
	public void setSortCreatedDate(String sortCreatedDate) {
		this.sortCreatedDate = sortCreatedDate;
	}
}
