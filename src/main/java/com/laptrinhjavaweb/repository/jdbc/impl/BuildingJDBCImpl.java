package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingJDBCImpl extends BaseJDBCImpl implements IBuildingJDBC {
	
	private Connection connection;
	private PreparedStatement prStatement;
	private ResultSet resultSet;

	@Override
	public List<BuildingEntity> findByCondition(BuildingRequestDTO buildingRequest) {
		List<BuildingEntity> results = new ArrayList<>();
		try {
			this.connection = super.getConnection();
			this.connection.setAutoCommit(false);
			this.prStatement = this.connection.prepareStatement(this.buildQueryForSearchBuilding(buildingRequest));

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
	public String buildQueryForSearchBuilding(BuildingRequestDTO buildingRequest) {
		try {
			return new StringBuilder("SELECT * FROM building BD ")
					.append(this.buildJoinSQLClause(buildingRequest))
					.append(this.buildWhereSQLClause(buildingRequest))
					.append(" GROUP BY BD.id ").toString();
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
		String[] assignmentbuilding = {" JOIN assignmentbuilding ASB on  ASB.buildingid = BD.id "};
		String[] rentarea = {" JOIN rentarea RE ON RE.buildingid = BD.id "};
		String[] buildingrenttype = {" JOIN buildingrenttype BRT ON BRT.buildingid = BD.id ",
				" JOIN renttype RT ON RT.id = BRT.renttypeid "};
		StringBuilder joinSQLClause = new StringBuilder(" JOIN district DT on DT.id = BD.districtid ")
				.append(this.checkExistenceOfJoinSQLClause(assignmentbuilding,buildingRequest.getUserID()))
				.append(this.checkExistenceOfJoinSQLClause(rentarea,buildingRequest.getRentAreaFrom(), buildingRequest.getRentAreaTo()))
				.append(this.checkExistenceOfJoinSQLClause(buildingrenttype, buildingRequest.getListType()));

		return joinSQLClause.toString();
	}

	@Override
	public String buildConditionForBuildingType(List<String> buildingType) {
		StringBuilder conditionForBuildingType = new StringBuilder("");
		if (!this.isNull(buildingType) && buildingType.size() > 0) {
			if(!isBlank(buildingType.get(0))) {
				conditionForBuildingType.append(" AND RT.code = \"" + buildingType.get(0) + "\" ");
			}
			if (buildingType.size() > 1) {
				for (int i = 1; i < buildingType.size(); i++) {
					if(!isBlank(buildingType.get(i))){
						conditionForBuildingType.append(" OR RT.code = \"" + buildingType.get(i) + "\" ");
					}
				}
			}
		}
		return conditionForBuildingType.toString();
	}

	@Override
	public String checkExistenceOfConditionV2(String prefix, String suffix, Object parameter) {
		if(parameter != null && !this.isBlank(parameter)) {
			return (prefix + parameter + suffix);
		}
		return "";
	}
	
	@Override
	public String checkExistenceOfJoinSQLClause(String[] joinStr, Object...parameters) { // optimal
		StringBuilder joinClauseStr = new StringBuilder("");
		for(Object obj: parameters) {
			if(obj != null && !isBlank(obj)) {
				for(String str: joinStr) {
					joinClauseStr.append(str);
				}
				return joinClauseStr.toString();
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
	

	@Override
	public StringBuilder checkAndKeyword(boolean temp, StringBuilder string) {
		if(temp == false) {
			return new StringBuilder(" WHERE " + string.toString());
		}else {
			return new StringBuilder(" AND ").append(string.toString());
		}
	}

	@Override
	public String buildQuery(BuildingRequestDTO buildingRequest) {
		try {
			boolean temp = false;// keyword AND not exists
			String sqlFromClause = "SELECT * FROM building BD ";
			//StringBuilder sqlFromClause = new StringBuilder("SELECT * FROM building BD ");
			StringBuilder whereSQLClause = new StringBuilder("");
			if (buildingRequest.getDistrictID() != null) {
				//sqlFromClause.append(", district DTrict");// insert table into from
				sqlFromClause += ", district DTrict";

				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("BD.districtid = DTrict.id ")));
				temp = true; // keyword AND exists
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("DTrict.id = " + buildingRequest.getDistrictID() + " ")));
				
			}
			if (buildingRequest.getName() != null) {
				whereSQLClause.append(
						this.checkAndKeyword(temp, new StringBuilder("BD.name LIKE '%" + buildingRequest.getName() + "%' ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getRentAreaFrom() != null || buildingRequest.getRentAreaTo() != null) {
				//sqlFromClause.append(", rentarea RErea");
				sqlFromClause += ", rentarea RErea";
				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("RErea.buildingid = BD.id ")));
				temp = true; // keyword AND exists
				if (buildingRequest.getRentAreaFrom() != null && buildingRequest.getRentAreaTo() != null) {
					whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("RErea.value BETWEEN "
							+ buildingRequest.getRentAreaFrom() + " " + buildingRequest.getRentAreaTo() + " ")));
				}
				if (buildingRequest.getRentAreaFrom() != null && buildingRequest.getRentAreaTo() == null) {
					whereSQLClause.append(this.checkAndKeyword(temp,
							new StringBuilder("RErea.value >= " + buildingRequest.getRentAreaFrom() + " ")));
				}
				if (buildingRequest.getRentAreaFrom() == null && buildingRequest.getRentAreaTo() != null) {
					whereSQLClause.append(this.checkAndKeyword(temp,
							new StringBuilder("RErea.value <= " + buildingRequest.getRentAreaTo() + " ")));
				}
			}
			if (buildingRequest.getUserID() != null) {
				//sqlFromClause.append(", user U, assignmentbuilding Abuilding");// insert table into from
				sqlFromClause += ", user U, assignmentbuilding Abuilding";
				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("Abuilding.staffid = U.id ")));
				temp = true; // keyword AND exists
				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("Abuilding. Buildingid = BD.id ")));
				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("U.id = " + buildingRequest.getUserID() + " ")));
			}
			if (buildingRequest.getFloorArea() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.floorarea = " + buildingRequest.getFloorArea() + " ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getWard() != null) {
				whereSQLClause.append(
						this.checkAndKeyword(temp, new StringBuilder("BD.ward LIKE '%" + buildingRequest.getWard() + "%' ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getStreet() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.street LIKE '%" + buildingRequest.getStreet() + "%' ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getNumberOfBasement() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.numberOfBasement = " + buildingRequest.getNumberOfBasement() + " ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getRentPriceFrom() != null && buildingRequest.getRentPriceTo() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("BD.rentprice BETWEEN "
						+ buildingRequest.getRentPriceFrom() + " AND " + buildingRequest.getRentPriceTo() + " ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getRentPriceFrom() != null && buildingRequest.getRentPriceTo() == null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.rentprice >= " + buildingRequest.getRentPriceFrom() + " ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getRentPriceFrom() == null && buildingRequest.getRentPriceTo() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.rentprice <= " + buildingRequest.getRentPriceTo() + " ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getDirection() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.direction  LIKE '%" + buildingRequest.getDirection() + "%' ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getLevel() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.Level LIKE '%" + buildingRequest.getLevel() + "%' ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getManagerName() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.managername LIKE '%" + buildingRequest.getManagerName() + "%' ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getManagerPhone() != null) {
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("BD.managerphone LIKE '%" + buildingRequest.getManagerPhone() + "%' ")));
				temp = true; // keyword AND exists
			}
			if (buildingRequest.getListType() != null) {
				//sqlFromClause.append(", renttype RType");// insert table into from
				sqlFromClause += ", renttype RType";
				//sqlFromClause.append(", buildingrenttype BRType");// insert table into from
				sqlFromClause += ", buildingrenttype BRType";
				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("RType.id = BRType. Renttypeid ")));
				temp = true; // keyword AND exists
				whereSQLClause.append(this.checkAndKeyword(temp, new StringBuilder("BD.id = BRType. buildingid ")));
				whereSQLClause.append(this.checkAndKeyword(temp,
						new StringBuilder("RType.id = " + buildingRequest.getListType().get(0) + " ")));
				if (buildingRequest.getListType().size() > 1) {
					for (int i = 1; i < buildingRequest.getListType().size(); i++) {
						whereSQLClause.append(new StringBuilder("OR RType.id = " + buildingRequest.getListType().get(i) + " "));
					}
				}
			}
			String result = sqlFromClause + whereSQLClause.toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String checkExistenceOfCondition (String conditionStr, Object parameter) {
		if(parameter != null && !this.isBlank(parameter)) {
			return conditionStr;
		}
		return "";
	}

	@Override
	public BuildingDTO convertResultSetToBuildingDTO(ResultSet resultSet) {
		try {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setId(resultSet.getLong("id"));
			buildingDTO.setName(resultSet.getString("name"));
			buildingDTO.setDistrictID(resultSet.getLong("districtid"));
			buildingDTO.setStreet(resultSet.getString("street"));
			buildingDTO.setStructure(resultSet.getString("structure"));
			buildingDTO.setNumberOfBasement(resultSet.getLong("numberofbasement"));
			buildingDTO.setFloorArea(resultSet.getLong("floorarea"));
			buildingDTO.setDirection(resultSet.getString("direction"));
			buildingDTO.setLevel(resultSet.getString("level"));
			buildingDTO.setRentPrice(resultSet.getLong("rentPrice"));
			buildingDTO.setRentPriceDescription(resultSet.getString("rentPriceDescription"));
			buildingDTO.setServiceFee(resultSet.getString("serviceFee"));
			buildingDTO.setCarFee(resultSet.getString("carFee"));
			buildingDTO.setMotorbikeFee(resultSet.getString("motorbikeFee"));
			buildingDTO.setOvertimeFee(resultSet.getString("overtimeFee"));
			buildingDTO.setWaterFee(resultSet.getString("waterfee"));
			buildingDTO.setElectricityFee(resultSet.getString("electricityfee"));
			buildingDTO.setDeposit(resultSet.getString("deposit"));
			buildingDTO.setPayment(resultSet.getString("payment"));
			buildingDTO.setRentTime(resultSet.getString("renttime"));
			buildingDTO.setDecoratorTime(resultSet.getString("decorationtime"));
			buildingDTO.setBrokerageFee(resultSet.getString("brokeragefee"));
			buildingDTO.setNote(resultSet.getString("note"));
			buildingDTO.setLinkofbuilding(resultSet.getString("linkofbuilding"));
			buildingDTO.setMap(resultSet.getString("map"));
			buildingDTO.setImage(resultSet.getString("image"));
			buildingDTO.setManagerPhone(resultSet.getString("managerphone"));
			buildingDTO.setManagerName(resultSet.getString("managername"));

			buildingDTO.setCreatedDate(resultSet.getTimestamp("createddate"));
			buildingDTO.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			buildingDTO.setCreatedBy(resultSet.getString("createdby"));
			buildingDTO.setModifiedBy(resultSet.getString("modifiedby"));

			return buildingDTO;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public BuildingEntity convertResultSetToEntity(ResultSet resultSet) {
		try {
			BuildingEntity buildingEntity = new BuildingEntity();
			buildingEntity.setId(resultSet.getLong("id"));
			buildingEntity.setName(resultSet.getString("name"));
			//buildingEntity.setDistrict(resultSet.getObject("districtid", DistrictEntity.class));
			buildingEntity.setDistrictId(resultSet.getLong("districtid"));
			buildingEntity.setStreet(resultSet.getString("street"));
			buildingEntity.setNumberOfBasement(resultSet.getInt("numberofbasement"));
			buildingEntity.setManagerPhone(resultSet.getString("managerphone"));
			buildingEntity.setManagerName(resultSet.getString("managername"));

			return buildingEntity;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
