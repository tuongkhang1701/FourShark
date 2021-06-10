package com.fourshark.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fourshark.dao.IOrderDAO;
import com.fourshark.model.OrderModel;
import com.fourshark.paging.Pageble;
import com.fourshark.service.IOrderService;

public class OrderService implements IOrderService{

	@Inject
	private IOrderDAO orderDAO;
	
	@Override
	public OrderModel addOrder(OrderModel model) {
		Long id = orderDAO.addOrder(model);
		return orderDAO.findById(id);
	}

	@Override
	public void deleteOrder(long id) {
		orderDAO.delete(id);
	}

	@Override
	public List<OrderModel> findAll(Pageble pageble) {
		return orderDAO.findAll(pageble);
	}

	@Override
	public OrderModel findById(Long id) {
		// TODO Auto-generated method stub
		return orderDAO.findById(id);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return orderDAO.getTotalItem();
	}

	@Override
	public List<OrderModel> findAll() {
		// TODO Auto-generated method stub
		return orderDAO.findAll();
	}

}
