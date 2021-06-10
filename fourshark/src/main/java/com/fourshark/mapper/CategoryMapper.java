package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fourshark.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(rs.getLong("Id"));
			categoryModel.setName(rs.getString("Name"));
			categoryModel.setParentCategory(rs.getString("ParentCategory"));
			categoryModel.setCode(rs.getString("Code"));
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
		
		
	}

}
