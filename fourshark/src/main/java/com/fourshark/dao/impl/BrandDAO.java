package com.fourshark.dao.impl;

import java.util.List;

import com.fourshark.dao.IBrandDAO;
import com.fourshark.mapper.BrandMapper;
import com.fourshark.model.BrandModel;

public class BrandDAO extends AbstractDAO<BrandModel> implements IBrandDAO{

	@Override
	public List<BrandModel> findAll() {
		String sql = "SELECT * FROM Brands";
		
		List<BrandModel> list = query(sql, new BrandMapper());
		return list;
	}



	@Override
	public BrandModel findOneById(long id) {
		String sql = "SELECT * FROM Brands WHERE Id = ?";
		
		List<BrandModel> list = query(sql, new BrandMapper(), id);
		return list.isEmpty()?null:list.get(0);
	}

}
