package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.jdbc.IUserJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCImpl extends BaseJDBCImpl implements IUserJDBC {
    private Connection connection;
    private PreparedStatement prStatement;
    private ResultSet resultSet;

    @Override
    public List<UserEntity> getStaffs() {
        StringBuilder sql = new StringBuilder("SELECT U.id, U.fullname ")
                .append(" FROM USER U, USER_ROLE UR ")
                .append(" WHERE U.id = UR.userid ")
                .append(" AND UR.roleid = 2 ");
        List<UserEntity> results = new ArrayList<>();
        try {
            this.connection = super.getConnection();
            this.connection.setAutoCommit(false);
            this.prStatement = this.connection.prepareStatement(sql.toString());

            this.resultSet = this.prStatement.executeQuery();
            while (this.resultSet.next()) {
                // get All data from resultset
                results.add(this.convertResultSetToEntity(resultSet));
            }
            this.connection.commit();
            return results;

        } catch (SQLException e) {
            try {
                if (this.connection != null) {
                    this.connection.rollback();
                    e.printStackTrace();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            return null;
        } finally {
            closeAll(this.connection, this.prStatement, this.resultSet);
        }
    }

    @Override
    public UserEntity convertResultSetToEntity(ResultSet resultSet) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(resultSet.getLong("id"));
            userEntity.setFullName(resultSet.getString("fullname"));

            return userEntity;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
