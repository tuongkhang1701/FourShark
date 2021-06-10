package com.fourshark.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fourshark.dao.IBrandDAO;
import com.fourshark.model.BrandModel;
import com.fourshark.service.IBrandService;

public class BrandService implements IBrandService {
	
	@Inject IBrandDAO brandDAO;

	@Override
	public List<BrandModel> findAll() {
		
		return brandDAO.findAll();
	}

}
