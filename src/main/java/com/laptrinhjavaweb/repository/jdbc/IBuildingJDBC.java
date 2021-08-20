package com.laptrinhjavaweb.repository.jdbc;

import java.sql.ResultSet;
import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingJDBC{
	List<BuildingEntity> findByCondition(BuildingRequestDTO buildingRequest);
	String buildQueryForSearchBuilding(BuildingRequestDTO buildingRequest);
	
	//Build Clauses
	String buildJoinSQLClause(BuildingRequestDTO buildingRequest);
	String buildWhereSQLClause(BuildingRequestDTO buildingRequest);
	String buildConditionForBuildingType(List<String> buildingType);
	String buildBetweenStatement(String sqlWhere, Long from, Long to);
	//String buildFromSQLClause(String select, String from);
	
	// Build condition
	String checkExistenceOfConditionV2(String prefix, String suffix, Object parameter);
	String checkExistenceOfJoinSQLClause(String[] joinStr, Object... parameters);
	boolean isNull(Object value);
	boolean isBlank(Object value);
	
	
	// For first version
	BuildingEntity convertResultSetToEntity(ResultSet resultSet);
	BuildingDTO convertResultSetToBuildingDTO(ResultSet resultSet);
	String buildQuery(BuildingRequestDTO buildingRequest);
	String checkExistenceOfCondition(String conditionStr, Object parameter);
	StringBuilder checkAndKeyword(boolean temp, StringBuilder string);
}
