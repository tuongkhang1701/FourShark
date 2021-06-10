package com.fourshark.service;

import java.util.List;

import com.fourshark.model.OrderModel;
import com.fourshark.paging.Pageble;

public interface IOrderService {
	OrderModel addOrder(OrderModel orderModel);
	
	void deleteOrder(long id);
	
	List<OrderModel> findAll(Pageble pageble);
	int getTotalItem();
	OrderModel findById(Long id);
	
	List<OrderModel> findAll();
}
