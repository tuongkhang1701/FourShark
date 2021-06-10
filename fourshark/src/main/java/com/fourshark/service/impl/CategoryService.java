package com.fourshark.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fourshark.dao.ICategoryDAO;
import com.fourshark.model.CategoryModel;
import com.fourshark.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}
	
	public ICategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(ICategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public CategoryModel findOne(long id) {
		
		return categoryDAO.findOneById(id);
	}

	@Override
	public List<CategoryModel> getListParentCategory() {
		
		return categoryDAO.getListParentCategory();
	}

	@Override
	public List<CategoryModel> getListCategory(long id) {
		
		return categoryDAO.getListCategory(id);
	}

}
