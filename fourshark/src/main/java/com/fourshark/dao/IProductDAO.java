package com.fourshark.dao;

import java.util.ArrayList;
import java.util.List;

import com.fourshark.model.ProductModel;
import com.fourshark.paging.Pageble;

public interface IProductDAO extends GenericDAO<ProductModel>{
	
	ProductModel findProduct(Long ID);
	
	ArrayList<ProductModel> findAll();
	
	List<ProductModel> findAll(Pageble pageble);
	
	List<ProductModel> getListProductByCategory(String id);
	
	Long save(ProductModel productModel);
	
	void update(ProductModel newProduct);
	
	void delete(long id);
	
	ProductModel findOneById(Long id);
	
	int getTotalItem();
	
	List<ProductModel> findByKeyword(String keyword);
	
	List<ProductModel> findByCategoryId(Long categoryId);
}
