package com.fourshark.dao;

import com.fourshark.model.RoleModel;

public interface IRoleDAO extends GenericDAO<RoleModel> {

	RoleModel findClient();
}
