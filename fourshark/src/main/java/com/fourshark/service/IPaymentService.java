package com.fourshark.service;

import java.util.List;

import com.fourshark.model.PaymentModel;

public interface IPaymentService {
	List<PaymentModel> findAll();
	
	PaymentModel findById(Long id);
}
