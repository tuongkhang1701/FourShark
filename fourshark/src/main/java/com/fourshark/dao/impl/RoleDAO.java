package com.fourshark.dao.impl;

import java.util.List;

import com.fourshark.dao.IRoleDAO;
import com.fourshark.mapper.RoleMapper;
import com.fourshark.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{

	@Override
	public RoleModel findClient() {
		String sql = "SELECT * FROM Roles WHERE Code = 'USER'";
		List<RoleModel> list = query(sql, new RoleMapper());
		return list!=null?list.get(0):null;
	}
}
