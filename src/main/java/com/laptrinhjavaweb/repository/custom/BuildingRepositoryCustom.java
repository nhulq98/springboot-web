package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll();

    List<BuildingEntity> findByCondition(BuildingRequestDTO buildingRequestDTO);

    String buildQueryV2(BuildingRequestDTO buildingRequest);

    //Build Clauses
    String buildJoinSQLClause(BuildingRequestDTO buildingRequest);
    String buildWhereSQLClause(BuildingRequestDTO buildingRequest);
    String buildConditionForBuildingType(List<String> buildingType);
    String buildBetweenStatement(String sqlWhere, Long from, Long to);

    // Build condition
    String checkExistenceOfConditionV2(String prefix, String suffix, Object parameter);
    String checkExistenceOfJoinSQLClause(String[] joinStr, Object... parameters);
    boolean isNull(Object value);
    boolean isBlank(Object value);
}
