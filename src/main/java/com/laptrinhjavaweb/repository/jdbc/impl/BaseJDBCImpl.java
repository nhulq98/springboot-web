package com.laptrinhjavaweb.repository.jdbc.impl;

import java.sql.*;
import java.util.ResourceBundle;

import com.laptrinhjavaweb.repository.jdbc.IBaseJDBC;

public class BaseJDBCImpl implements IBaseJDBC{
	ResourceBundle dbResourceBundle = ResourceBundle.getBundle("application");
	private String PASSWORD = dbResourceBundle.getString("password");
	private String URL = dbResourceBundle.getString("url");
	private String USER = dbResourceBundle.getString("userName");
	private String DRIVER_NAME = dbResourceBundle.getString("driverName");

	@Override
	public Connection getConnection() {
		try {
			// Load the Connector driver
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
		} catch (SQLException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}

	}

	@Override
	public void closeAll(Connection connection, PreparedStatement prStatement, ResultSet resultSet) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (prStatement != null) {
				prStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return;
		}
	}

	@Override
	public void setParameters(PreparedStatement prStatement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				// way 1:
				// prStatement.setObject(i + 1, parameters[i]);

				// way 2:
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					prStatement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					prStatement.setString(index, (String) parameter);
				} else if (parameter instanceof Timestamp) {
					prStatement.setTimestamp(index, (Timestamp) parameter);
				} else if (parameter instanceof Integer) {
					prStatement.setInt(index, (Integer) parameter);
				} else if (parameter == null) {
					prStatement.setNull(index, Types.NULL);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
