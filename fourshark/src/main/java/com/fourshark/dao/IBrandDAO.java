package com.fourshark.dao;

import java.util.List;

import com.fourshark.model.BrandModel;

public interface IBrandDAO extends GenericDAO<BrandModel> {
	
	List<BrandModel> findAll();

	BrandModel findOneById(long id);
}
