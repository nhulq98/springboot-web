package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll() {
        String sql = "select * from building";
        Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public List<BuildingEntity> findByCondition(BuildingRequestDTO buildingRequestDTO) {
        String sql = this.buildQueryV2(buildingRequestDTO);
        Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
        return query.getResultList();
    }


    @Override
    public String buildQueryV2(BuildingRequestDTO buildingRequest) {
        try {
            String fromSQLClause = "SELECT * FROM building BD ";
            String joinSQLClause = this.buildJoinSQLClause(buildingRequest);
            String whereSQLClause = this.buildWhereSQLClause(buildingRequest);
            String groupByClause = " GROUP BY BD.id ";

            return (fromSQLClause + joinSQLClause + whereSQLClause.toString() + groupByClause);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String buildBetweenStatement(String whereSQLClause, Long from, Long to) {
        if(!this.isNull(from) || !this.isNull(to)) {
            if(!this.isNull(from) && !this.isNull(to)) {
                return (" AND "+ whereSQLClause +" BETWEEN " + from + " AND " + to + " ");
            }else if(!this.isNull(from) && this.isNull(to)) {
                return (" AND "+ whereSQLClause +" >= " + from + " ");
            }else {
                return (" AND "+ whereSQLClause +" <= " + to + " ");
            }
        }
        return "";
    }

    @Override
    public String buildWhereSQLClause(BuildingRequestDTO buildingRequest) {
        StringBuilder whereSQLClause = new StringBuilder(" WHERE 1=1 ");// Use StringBuilder with purpose is saved memory

        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.name LIKE '%", "%' ", buildingRequest.getName()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.street LIKE '%", "%' ", buildingRequest.getStreet()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.ward LIKE '%", "%' ", buildingRequest.getWard()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.districtid = ", " ", buildingRequest.getDistrictID()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.floorarea = ", " ", buildingRequest.getFloorArea()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.numberOfBasement = ", " ", buildingRequest.getNumberOfBasement()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.direction  LIKE '%", "%' ", buildingRequest.getDirection()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.Level LIKE '%", "%' ", buildingRequest.getLevel()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.managername LIKE '%", "%' ", buildingRequest.getManagerName()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND BD.managerphone LIKE '%", "%' ", buildingRequest.getManagerPhone()));
        whereSQLClause.append(this.checkExistenceOfConditionV2 (" AND ASB.staffid = ", " ", buildingRequest.getUserID()));
        whereSQLClause.append(this.buildBetweenStatement("BD.rentprice", buildingRequest.getRentPriceFrom(), buildingRequest.getRentPriceTo()));
        whereSQLClause.append(this.buildBetweenStatement("RE.value", buildingRequest.getRentAreaFrom(), buildingRequest.getRentAreaTo()));
        whereSQLClause.append(this.buildConditionForBuildingType(buildingRequest.getListType()));

        return whereSQLClause.toString();
    }

    @Override
    public String buildJoinSQLClause(BuildingRequestDTO buildingRequest) {
        String joinSQLClause = " JOIN district DT on DT.id = BD.districtid ";

        String[] assignmentbuilding = {" JOIN assignmentbuilding ASB on  ASB.buildingid = BD.id "};
        joinSQLClause += this.checkExistenceOfJoinSQLClause(assignmentbuilding,
                buildingRequest.getUserID());

        String[] rentarea = {" JOIN rentarea RE ON RE.buildingid = BD.id "};
        joinSQLClause += this.checkExistenceOfJoinSQLClause(rentarea,
                buildingRequest.getRentAreaFrom(), buildingRequest.getRentAreaTo());

        String[] buildingrenttype = {" JOIN buildingrenttype BRT ON BRT.buildingid = BD.id ",
                " JOIN renttype RT ON RT.id = BRT.renttypeid "};
        joinSQLClause += this.checkExistenceOfJoinSQLClause(buildingrenttype, buildingRequest.getListType());

        return joinSQLClause;
    }

    @Override
    public String buildConditionForBuildingType(List<String> buildingType) {
        String conditionForBuildingType = "";
        if (!this.isNull(buildingType)) {
            conditionForBuildingType += " AND RT.code = \"" + buildingType.get(0) + "\" ";
            if (buildingType.size() > 1) {
                for (int i = 1; i < buildingType.size(); i++) {
                    conditionForBuildingType += " OR RT.code = \"" + buildingType.get(i) + "\" ";
                }
            }
        }
        return conditionForBuildingType;
    }

    @Override
    public String checkExistenceOfConditionV2(String prefix, String suffix, Object parameter) {
        if(parameter != null && !this.isBlank(parameter)) {
            return (prefix + parameter + suffix);
        }
        return "";
    }

    @Override
    public String checkExistenceOfJoinSQLClause(String[] joinStr, Object...parameters) {
        String joinClauseStr = "";
        for(Object obj: parameters) {
            if(obj != null) {
                for(String str: joinStr) {
                    joinClauseStr += str;
                }
                return joinClauseStr;
            }
        }
        return "";
    }

    @Override
    public boolean isNull(Object value) {
        if(value == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isBlank(Object value) {
        if(value instanceof String && value == "") {
            return true;
        }
        return false;
    }
}
