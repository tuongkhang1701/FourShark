package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fourshark.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {

	@Override
	public RoleModel mapRow(ResultSet rs) {
		RoleModel roleModel = new RoleModel();
		try {
			roleModel.setCode(rs.getString("Code"));
			roleModel.setName(rs.getString("Name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return roleModel;
	}

}