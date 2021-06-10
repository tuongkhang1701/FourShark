package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fourshark.model.RoleModel;
import com.fourshark.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(rs.getLong("Id"));
			userModel.setPassword(rs.getString("Password"));
			userModel.setEmail(rs.getString("Email"));
			userModel.setphoneNumber(rs.getString("PhoneNumber"));
			userModel.setfullName(rs.getString("Fullname"));
			userModel.setGender(rs.getString("Gender"));
			userModel.setCreatedDate(rs.getTimestamp("CreatedDate"));
			userModel.setModifiedDate(rs.getTimestamp("ModifiedDate"));
			
			try {
				RoleModel roleModel = new RoleModel();
				roleModel.setCode(rs.getString("Code"));
				roleModel.setName(rs.getString("Name"));
				roleModel.setId(rs.getLong("RoleId"));
				userModel.setRole(roleModel);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
