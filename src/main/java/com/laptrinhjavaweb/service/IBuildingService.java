package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingResponseDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
	Map<String, String> getDistricts();
	Map<String, String> getBuildingTypes();
	BuildingDTO save(BuildingDTO newBuilding);
	List<BuildingResponseDTO> findByCondition(BuildingRequestDTO buildingRequest);

	List<BuildingDTO> findAll();

//	List<BuildingDTO> getBuildings();
}
