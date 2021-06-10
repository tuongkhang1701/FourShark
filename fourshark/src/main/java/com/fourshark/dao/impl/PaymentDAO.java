package com.fourshark.dao.impl;

import java.util.List;

import com.fourshark.dao.IPaymentDAO;
import com.fourshark.mapper.PaymentMapper;
import com.fourshark.mapper.UserMapper;
import com.fourshark.model.PaymentModel;
import com.fourshark.model.UserModel;

public class PaymentDAO extends AbstractDAO<PaymentModel> implements IPaymentDAO{

	@Override
	public List<PaymentModel> findAll() {
		String sql = "SELECT * FROM PaymentMethods";
		
		List<PaymentModel> list = query(sql, new PaymentMapper());
		return list;
	}

	@Override
	public PaymentModel findById(Long id) {
		String sql = "SELECT * FROM PaymentMethods WHERE Id = ?";

		List<PaymentModel> list = query(sql, new PaymentMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

}
