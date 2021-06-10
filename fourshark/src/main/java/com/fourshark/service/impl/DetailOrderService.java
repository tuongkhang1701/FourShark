package com.fourshark.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fourshark.dao.IDetailOrderDAO;
import com.fourshark.model.DetailOrderModel;
import com.fourshark.paging.Pageble;
import com.fourshark.service.IDetailOrderService;

public class DetailOrderService implements IDetailOrderService{

	@Inject
	private IDetailOrderDAO detailOrderDAO;
	@Override
	public List<DetailOrderModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return detailOrderDAO.findAll(pageble);
	}

	@Override
	public Long addDetailOrder(DetailOrderModel detailOrderModel) {
		// TODO Auto-generated method stub
		return detailOrderDAO.addDetailOrder(detailOrderModel);
	}

	@Override
	public void delete(long id) {
		detailOrderDAO.delete(id);
		
	}

	@Override
	public List<DetailOrderModel> findById(Long id) {
		// TODO Auto-generated method stub
		return detailOrderDAO.findById(id);
	}

}
