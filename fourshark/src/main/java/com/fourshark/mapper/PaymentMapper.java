package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fourshark.model.PaymentModel;

public class PaymentMapper implements RowMapper<PaymentModel>{

	@Override
	public PaymentModel mapRow(ResultSet rs) {
		PaymentModel paymentModel = new PaymentModel();
		try {
			paymentModel.setId(rs.getLong("Id"));
			paymentModel.setName(rs.getString("Name"));
			return paymentModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
