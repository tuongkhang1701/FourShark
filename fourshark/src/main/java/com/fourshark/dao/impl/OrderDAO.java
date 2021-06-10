package com.fourshark.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fourshark.dao.IOrderDAO;
import com.fourshark.mapper.OrderMapper;
import com.fourshark.model.OrderModel;
import com.fourshark.paging.Pageble;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO{

	@Override
	public List<OrderModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM Orders AS O, PaymentMethods AS P WHERE O.PaymentMethodId = P.Id ");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortCreatedDate()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append("ORDER BY " + pageble.getSorter().getSortCreatedDate() + " " + pageble.getSorter().getSortBy() + " ");
		}
		else {
			sql.append("ORDER BY O.Id ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS ");
			sql.append("FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new OrderMapper());
	}

	@Override
	public long addOrder(OrderModel model) {
		StringBuilder sql = new StringBuilder("INSERT INTO Orders(CreatedDate, PaymentMethodId, UserId, DeliveryAddress) ");
		sql.append("Values (?, ?, ?, ?)");

		Long id = insert(sql.toString(), model.getCreatedDate(), model.getPaymentMethod().getId(), model.getUser().getId(), model.getDeliveryAddress());
		return id;
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM Orders WHERE Id = ?";

		update(sql, id);
	}

	@Override
	public OrderModel findById(Long id) {
		String sql = "SELECT * FROM Orders WHERE Id = ?";

		List<OrderModel> list = query(sql, new OrderMapper(), id);
		
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM Orders";
		return count(sql);
	}

	@Override
	public List<OrderModel> findAll() {
		String sql = "SELECT * FROM Orders, PaymentMethods WHERE Orders.PaymentMethodId = PaymentMethods.Id";
		List<OrderModel> list = query(sql.toString(), new OrderMapper());
		return list;
	}


}
