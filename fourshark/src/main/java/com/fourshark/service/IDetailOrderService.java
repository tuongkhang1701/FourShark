package com.fourshark.service;

import java.util.List;

import com.fourshark.model.DetailOrderModel;
import com.fourshark.model.ProductModel;
import com.fourshark.paging.Pageble;

public interface IDetailOrderService {
	List<DetailOrderModel> findAll(Pageble pageble);
	
	List<DetailOrderModel> findById(Long id);
	
	Long addDetailOrder(DetailOrderModel detailOrderModel);
	
	void delete(long id);
}
