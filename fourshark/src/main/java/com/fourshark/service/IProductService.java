package com.fourshark.service;

import java.util.List;

import com.fourshark.model.ProductModel;
import com.fourshark.paging.Pageble;

public interface IProductService {
	ProductModel findProduct(Long ID);
	List<ProductModel> findByCategoryId(Long categoryId);
	ProductModel save(ProductModel ProductModel);
	ProductModel update(ProductModel updateNew);
	void delete(long[] ids);
	List<ProductModel> findAll(Pageble pageble);
	
	List<ProductModel> findAll();
	int getTotalItem();
	ProductModel findOneById(long id);
	
	List<ProductModel> findByKeyword(String keyword);
}
