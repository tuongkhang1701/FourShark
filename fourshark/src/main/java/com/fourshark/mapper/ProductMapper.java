package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fourshark.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet rs) {
		ArrayList<ProductModel> list = new ArrayList<ProductModel>();
		try {
			ProductModel productModel = new ProductModel();
			productModel.setId(rs.getLong("Id"));
			productModel.setName(rs.getString("Name"));
			productModel.setContent(rs.getString("Content"));
			productModel.setImage(rs.getString("Image"));
			productModel.setQuantity(rs.getInt("Quantity"));
			productModel.setPrice(rs.getBigDecimal("Price"));
			productModel.setCategoryId(rs.getLong("CategoryId"));
			productModel.setCreatedDate(rs.getTimestamp("CreatedDate"));
			productModel.setModifiedDate(rs.getTimestamp("ModifiedDate"));
			ProductModel products = new ProductModel(productModel.getId(), productModel.getName(), productModel.getPrice(), productModel.getImage());
			list.add(products);
			productModel.setList(list);

			return productModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
