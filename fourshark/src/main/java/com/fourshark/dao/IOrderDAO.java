package com.fourshark.dao;

import java.util.List;

import com.fourshark.model.OrderModel;
import com.fourshark.paging.Pageble;

public interface IOrderDAO extends GenericDAO<OrderModel>{
	List<OrderModel> findAll(Pageble pageble);
	
	List<OrderModel> findAll();
	
	long addOrder(OrderModel model);
	
	void delete(long id);
	
	OrderModel findById(Long id);
	
	int getTotalItem();
	
}
