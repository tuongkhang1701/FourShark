package com.fourshark.service;

import java.util.List;

import com.fourshark.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	
	CategoryModel findOne(long id);
	
	List<CategoryModel> getListParentCategory();
	
	List<CategoryModel> getListCategory(long id);
}
