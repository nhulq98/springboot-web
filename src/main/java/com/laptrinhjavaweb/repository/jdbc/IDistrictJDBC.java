package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.DistrictEntity;

import java.sql.ResultSet;
import java.util.List;

public interface IDistrictJDBC {
    DistrictEntity findById(Long id);
    List<DistrictEntity> findAll();
    DistrictEntity convertResultSetToEntity(ResultSet resultSet);
}
