package com.fourshark.dao.impl;

import java.util.List;

import com.fourshark.dao.ICategoryDAO;
import com.fourshark.mapper.CategoryMapper;
import com.fourshark.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from Categories";
		return query(sql, new CategoryMapper());
	}

	@Override
	public Long save(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryModel findOneById(Long id) {
		String sql = "select * from Categories where Id = ?";
		List<CategoryModel> list = query(sql, new CategoryMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "select * from Categories where Code = ?";
		List<CategoryModel> list = query(sql, new CategoryMapper(), code);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<CategoryModel> getListParentCategory() {
		String sql = "SELECT * FROM Categories WHERE ParentCategory IS NULL";
		return query(sql, new CategoryMapper());
	}

	@Override
	public List<CategoryModel> getListCategory(long id) {
		String sql = "SELECT * FROM Categories WHERE ParentCategory = ?";
		return query(sql, new CategoryMapper(), id);
	}

}
