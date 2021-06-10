package com.fourshark.dao;

import java.util.List;

import com.fourshark.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	
	List<CategoryModel> getListParentCategory();
	
	List<CategoryModel> getListCategory(long id);

	Long save(CategoryModel categoryModel);

	void update(CategoryModel categoryModel);

	void delete(Long id);

	CategoryModel findOneById(Long id);
	
	CategoryModel findOneByCode(String code);
}
