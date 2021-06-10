package com.fourshark.dao.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.util.Converter;
import com.fourshark.dao.IDetailOrderDAO;
import com.fourshark.mapper.DetailOrderMapper;
import com.fourshark.mapper.ProductMapper;
import com.fourshark.model.DetailOrderModel;
import com.fourshark.model.ProductModel;
import com.fourshark.paging.Pageble;

public class DetailOrderDAO extends AbstractDAO<DetailOrderModel> implements IDetailOrderDAO{

	@Override
	public List<DetailOrderModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM DetailOrders ");
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
		return query(sql.toString(), new DetailOrderMapper());
	}

	@Override
	public Long addDetailOrder(DetailOrderModel detailOrderModel) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(0);
		String priceStr = nf.format(detailOrderModel.getProduct().getPrice());
		String str = priceStr.replaceAll(",", "");
		BigDecimal price = new BigDecimal(str);
		StringBuilder sql = new StringBuilder("INSERT INTO DetailOrder(ProductId, Quantity, OrderId, Email, Price) ");
		sql.append("Values (?, ?, ?, ?, ?)");
		return insert(sql.toString(), detailOrderModel.getProduct().getId(), detailOrderModel.getQuantity(),
				detailOrderModel.getOrder().getId(), detailOrderModel.getEmail(), price);
		
	}


	@Override
	public void delete(long id) {
		String sql = "DELETE FROM DetailOrders WHERE Id = ?";

		update(sql, id);
		
	}

	@Override
	public List<DetailOrderModel> findById(Long id) {
		String sql = "SELECT * FROM DetailOrder WHERE OrderId = ?";
		List<DetailOrderModel> list = query(sql, new DetailOrderMapper(), id);
		return list.isEmpty()?null:list;
	}

}
