package com.fourshark.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fourshark.dao.IProductDAO;
import com.fourshark.mapper.ProductMapper;
import com.fourshark.model.ProductModel;
import com.fourshark.paging.Pageble;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
	ArrayList<ProductModel> list = null;
	@Override
	public List<ProductModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM Products ");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append("ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		else {
			sql.append("ORDER BY Id ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS ");
			sql.append("FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new ProductMapper());
	}

	@Override
	public Long save(ProductModel productModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO Products(CategoryId, Name, Quantity, Content, Price, ");
		sql.append("CreatedDate) ");
		sql.append("Values (?, ?, ?, ?, ?, ?)");

		return insert(sql.toString(), productModel.getCategoryId(), productModel.getName(),
				productModel.getQuantity() ,productModel.getContent(), productModel.getPrice(),
				productModel.getCreatedDate());
	}

	@Override
	public void update(ProductModel newProduct) {

		StringBuilder sql = new StringBuilder("UPDATE Products SET CategoryId = ?, Name = ?, ");
		sql.append("Quantity = ? ,Content = ?, Price = ?, ModifiedDate = ? WHERE Id = ?");

		update(sql.toString(), newProduct.getCategoryId(), newProduct.getName(), newProduct.getQuantity(),
				newProduct.getContent(), newProduct.getPrice(),
				newProduct.getModifiedDate(),
				newProduct.getId());

	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM Products WHERE Id = ?";

		update(sql, id);

	}

	@Override
	public ProductModel findOneById(Long id) {
		String sql = "SELECT * FROM Products WHERE Id = ?";

		List<ProductModel> list = query(sql, new ProductMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM Products";

		return count(sql);
	}

	@Override
	public List<ProductModel> getListProductByCategory(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM Products ");
		ArrayList<ProductModel> list = (ArrayList<ProductModel>) query(sql.toString(), new ProductMapper());
		return list;
	}
	
	public ProductModel findProduct(Long id)
	{
		String sql = "SELECT * FROM dbo.Products WHERE Id = ?";
		
		ProductMapper productMapper = new ProductMapper();
		List<ProductModel> list = query(sql, productMapper, id);
		
		
		
		for (ProductModel item : list) {
			if (item.getId() == id) {
				return item;
			}
		}
		
		return null;
		
	}

	@Override
	public List<ProductModel> findByKeyword(String keyword) {
		String sql = "SELECT * FROM Products WHERE Name LIKE '%"+keyword+"%'";
		List<ProductModel> list = query(sql, new ProductMapper());
		return list;
	}

	@Override
	public List<ProductModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM Products WHERE CategoryId = ?";
		List<ProductModel> list = query(sql, new ProductMapper(), categoryId);
		return list;
	}

}
