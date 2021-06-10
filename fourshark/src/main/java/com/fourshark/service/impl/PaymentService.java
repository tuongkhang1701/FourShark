package com.fourshark.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fourshark.dao.IPaymentDAO;
import com.fourshark.model.PaymentModel;
import com.fourshark.service.IPaymentService;

public class PaymentService implements IPaymentService{

	@Inject
	private IPaymentDAO paymentDAO;
	
	@Override
	public List<PaymentModel> findAll() {
		// TODO Auto-generated method stub
		return paymentDAO.findAll();
	}

	@Override
	public PaymentModel findById(Long id) {
		// TODO Auto-generated method stub
		return paymentDAO.findById(id);
	}

}
