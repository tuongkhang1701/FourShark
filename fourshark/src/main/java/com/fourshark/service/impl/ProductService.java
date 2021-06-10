package com.fourshark.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import com.fourshark.dao.IBrandDAO;
import com.fourshark.dao.ICategoryDAO;
import com.fourshark.dao.IProductDAO;
import com.fourshark.model.CategoryModel;
import com.fourshark.model.ProductModel;
import com.fourshark.paging.Pageble;
import com.fourshark.service.IProductService;

public class ProductService implements IProductService{
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Inject IBrandDAO brandDao;
	
	@Inject
	private IProductDAO productDao;

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	@Override
	public ProductModel save(ProductModel productModel) {
		productModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDAO.findOneByCode(productModel.getCategoryCode());
		productModel.setCategoryId(categoryModel.getId());
		Long newId = productDao.save(productModel);
		return productDao.findOneById(newId);	
	}

	@Override
	public List<ProductModel> findAll(Pageble pageble) {
		return productDao.findAll(pageble);
	}

	@Override
	public List<ProductModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return productDao.findByCategoryId(categoryId);
	}

	@Override
	public ProductModel update(ProductModel updateProduct) {
		CategoryModel categoryModel = new CategoryModel();
		updateProduct.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		categoryModel = categoryDAO.findOneByCode(updateProduct.getCategoryCode());
		updateProduct.setCategoryId(categoryModel.getId());
		productDao.update(updateProduct);
		return productDao.findOneById(updateProduct.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			productDao.delete(id);
		}
		
	}

	@Override
	public int getTotalItem() {
		return productDao.getTotalItem();
	}

	@Override
	public ProductModel findOneById(long id) {
		
		ProductModel productModel = productDao.findOneById(id);
		CategoryModel categoryModel = categoryDAO.findOneById(productModel.getCategoryId());
		productModel.setCategoryCode(categoryModel.getCode());
		return productModel;
	}

	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public ProductModel findProduct(Long id) {
		return productDao.findProduct(id);
	}

	@Override
	public List<ProductModel> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return productDao.findByKeyword(keyword);
	}


}
