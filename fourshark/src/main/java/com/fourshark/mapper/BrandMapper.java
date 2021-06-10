package com.fourshark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fourshark.model.BrandModel;

public class BrandMapper implements RowMapper<BrandModel>{
	@Override
	public BrandModel mapRow(ResultSet rs) {
		try {
			BrandModel brandModel = new BrandModel();
			brandModel.setId(rs.getLong("Id"));
			brandModel.setName(rs.getString("Name"));
			return brandModel;
		} catch (SQLException e) {
			return null;
		}
		
		
	}
}
