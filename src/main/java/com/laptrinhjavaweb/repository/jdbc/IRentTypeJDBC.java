package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.entity.RentTypeEntity;

import java.sql.ResultSet;
import java.util.List;

public interface IRentTypeJDBC {
    List<RentTypeEntity> findAll();
    RentTypeEntity convertResultSetToEntity(ResultSet resultSet);
}
