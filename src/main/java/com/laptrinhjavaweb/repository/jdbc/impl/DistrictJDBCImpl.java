package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.jdbc.IDistrictJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictJDBCImpl extends BaseJDBCImpl implements IDistrictJDBC{

    private Connection connection;
    private PreparedStatement prStatement;
    private ResultSet resultSet;

    @Override
    public DistrictEntity findById(Long id) {
        DistrictEntity districtEntity = new DistrictEntity();
        try {
            this.connection = super.getConnection();
            this.connection.setAutoCommit(false);
            this.prStatement = this.connection.prepareStatement("SELECT * FROM district WHERE id = " + id);

            this.resultSet = this.prStatement.executeQuery();
            while (this.resultSet.next()) {
                // get All data from resultset
                districtEntity = this.convertResultSetToEntity(resultSet);
            }
            this.connection.commit();
            return districtEntity;

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
    public List<DistrictEntity> findAll() {
        List<DistrictEntity> districtEntities = new ArrayList<>();
        try {
            this.connection = super.getConnection();
            this.connection.setAutoCommit(false);
            this.prStatement = this.connection.prepareStatement("SELECT * FROM district");

            this.resultSet = this.prStatement.executeQuery();
            while (this.resultSet.next()) {
                // get All data from resultset
                DistrictEntity districtEntity = this.convertResultSetToEntity(resultSet);
                districtEntities.add(districtEntity);
            }
            this.connection.commit();
            return districtEntities;

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
    public DistrictEntity convertResultSetToEntity(ResultSet resultSet) {
        try {
            DistrictEntity districtEntity = new DistrictEntity();
            districtEntity.setName(resultSet.getString("name"));
            districtEntity.setCode(resultSet.getString("code"));
            districtEntity.setId(resultSet.getLong("id"));

            return districtEntity;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
