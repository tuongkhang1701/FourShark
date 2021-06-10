package com.fourshark.dao;

import java.util.List;

import com.fourshark.model.PaymentModel;

public interface IPaymentDAO extends GenericDAO<PaymentModel> {
	List<PaymentModel> findAll();
	
	PaymentModel findById(Long id);
}
