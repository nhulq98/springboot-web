package com.laptrinhjavaweb.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IBaseJDBC {
	Connection getConnection();
	void closeAll(Connection connection, PreparedStatement prStatement, ResultSet resultSet);
	void setParameters(PreparedStatement prStatement, Object... parameters);
}
