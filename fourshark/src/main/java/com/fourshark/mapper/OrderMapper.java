package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fourshark.model.OrderModel;
import com.fourshark.model.PaymentModel;
import com.fourshark.model.UserModel;

public class OrderMapper implements RowMapper<OrderModel>{

	@Override
	public OrderModel mapRow(ResultSet rs) {
		try {
			OrderModel orderModel = new OrderModel();
			orderModel.setId(rs.getLong("Id"));
			orderModel.setDeliveryAddress(rs.getString("DeliveryAddress"));
			orderModel.setCreatedDate(rs.getTimestamp("CreatedDate"));
			try {
				UserModel userModel = new UserModel();
				userModel.setId(rs.getLong("UserId"));
				
				
				PaymentModel paymentModel = new PaymentModel();
				paymentModel.setId(rs.getLong("PaymentMethodId"));
				paymentModel.setName(rs.getString("Name"));
				orderModel.setPaymentMethod(paymentModel);
				orderModel.setUser(userModel);
			} catch (Exception e) {
				e.getStackTrace();
			}
			
			
			

			return orderModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
