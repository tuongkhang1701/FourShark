package com.fourshark.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.fourshark.dao.GenericDAO;
import com.fourshark.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	ResourceBundle bundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
			
			Class.forName(bundle.getString("driverName"));
			String hostName = bundle.getString("hostName");
			String sqlInstanceName = bundle.getString("sqlInstanceName");
			String database = bundle.getString("database");
			String userName = bundle.getString("userName");
			String password = bundle.getString("password");

			String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" //
					+ ";instance=" + sqlInstanceName + ";databaseName=" + database;

			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> list = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameters
			if (parameters != null) {
				setParameter(statement, parameters);
			}
			rs = statement.executeQuery();

			while (rs.next()) {

				list.add(rowMapper.mapRow(rs));
			}
			return list;
		} catch (SQLException e) {

			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object param = parameters[i];
				int index = i + 1;
				if (param instanceof Integer){
					statement.setInt(index, (Integer)param);
				} else if (param instanceof String) {
					statement.setString(index, (String)param);
				} else if (param instanceof Double) {
					statement.setDouble(index, (Double)param);
				}
				else if(param instanceof Long){
					statement.setLong(index, (Long)param);
				}
				else if (param instanceof Timestamp){
					statement.setTimestamp(index, (Timestamp)param);
				}
				else if (param instanceof BigDecimal){
					statement.setBigDecimal(index, (BigDecimal)param);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sql);

			// set parameters
			if (parameters != null) {
				setParameter(statement, parameters);
			}

			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Long id = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// set parameters
			if (parameters != null) {
				setParameter(statement, parameters);
			}
			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}

			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		int count = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameters
			if (parameters != null) {
				setParameter(statement, parameters);
			}
			rs = statement.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {

			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				return 0;
			}
		}
	}

}
