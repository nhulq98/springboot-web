package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.entity.UserEntity;

import java.sql.ResultSet;
import java.util.List;

public interface IUserJDBC {
    List<UserEntity> getStaffs();
    UserEntity convertResultSetToEntity(ResultSet resultSet);
}
