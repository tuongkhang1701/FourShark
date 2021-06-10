package com.fourshark.dao;

import java.util.List;

import com.fourshark.model.DetailOrderModel;
import com.fourshark.model.ProductModel;
import com.fourshark.paging.Pageble;

public interface IDetailOrderDAO extends GenericDAO<DetailOrderModel>{
	List<DetailOrderModel> findAll(Pageble pageble);
	
	List<DetailOrderModel> findById(Long id);
	
	Long addDetailOrder(DetailOrderModel detailOrderModel);
	
	void delete(long id);
	
	
}
