package com.fourshark.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fourshark.dao.IUserDAO;
import com.fourshark.mapper.UserMapper;
import com.fourshark.model.UserModel;
import com.fourshark.paging.Pageble;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public long save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO Users(Password, Email, PhoneNumber,");
		sql.append(" Fullname, Gender, RoleId, CreatedDate) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
		long id = insert(sql.toString(), userModel.getPassword(), userModel.getEmail(),
				userModel.getphoneNumber(), userModel.getfullName(), userModel.getGender(),
				userModel.getRole().getId(), userModel.getCreatedDate());
		return id;
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM Users ");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortCreatedDate()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append("ORDER BY " + pageble.getSorter().getSortCreatedDate() + " " + pageble.getSorter().getSortBy() + " ");
		}
		else {
			sql.append("ORDER BY Id ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS ");
			sql.append("FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		List<UserModel> list = query(sql.toString(), new UserMapper());
		return list;
	}

	@Override
	public void update(UserModel newUser) {
		StringBuilder sql = new StringBuilder("UPDATE Users SET Password = ? , PhoneNumber = ?,Fullname = ?, ");
		sql.append("Gender = ?, ModifiedDate = ? WHERE Id = ?");

		update(sql.toString(), newUser.getPassword(), newUser.getphoneNumber(), newUser.getfullName(), newUser.getGender(), newUser.getModifiedDate(), newUser.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM Users WHERE Id = ?";

		update(sql, id);
	}

	@Override
	public UserModel findOneById(Long id) {
		String sql = "SELECT * FROM Users WHERE Id = ?";

		List<UserModel> list = query(sql, new UserMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM Products";

		return count(sql);
	}

	@Override
	public boolean checkEmail(String email) {
		String sql = "SELECT * FROM Users WHERE Email = ?";

		List<UserModel> list = query(sql, new UserMapper(), email);
		return list.isEmpty()?false:true;
	}

	@Override
	public boolean checkUsername(String userName) {
		String sql = "SELECT * FROM Users WHERE Username = ?";

		List<UserModel> list = query(sql, new UserMapper(), userName);
		return list.isEmpty()?false:true;
	}

	@Override
	public UserModel findByEmailAndPasswordAndStatus(String email, String password) {
		String sql = "SELECT * FROM Users as u, Roles as r WHERE u.RoleId = r.Id AND u.Email = ? AND u.Password = ?";
		List<UserModel> list = query(sql.toString(), new UserMapper(), email, password);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM Users";
		
		List<UserModel> list = query(sql, new UserMapper());
		return list;
	}	

}
