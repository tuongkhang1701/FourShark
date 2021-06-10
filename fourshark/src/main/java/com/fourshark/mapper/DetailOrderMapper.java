package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fourshark.model.DetailOrderModel;
import com.fourshark.model.OrderModel;
import com.fourshark.model.ProductModel;

public class DetailOrderMapper implements RowMapper<DetailOrderModel>{

	@Override
	public DetailOrderModel mapRow(ResultSet rs) {
		try {
			DetailOrderModel detailOrderModel = new DetailOrderModel();
			detailOrderModel.setId(rs.getLong("Id"));
			detailOrderModel.setEmail(rs.getString("Email"));
			detailOrderModel.setQuantity(rs.getInt("Quantity"));
			detailOrderModel.setPrice(rs.getBigDecimal("Price"));
			
			OrderModel orderModel = new OrderModel();
			orderModel.setId(rs.getLong("OrderId"));
			
			ProductModel productModel = new ProductModel();
			productModel.setId(rs.getLong("ProductId"));
			
			detailOrderModel.setOrder(orderModel);
			detailOrderModel.setProduct(productModel);
			return detailOrderModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
