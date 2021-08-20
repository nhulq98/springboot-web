package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.BuildingResponseConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.jdbc.impl.BuildingJDBCImpl;
import com.laptrinhjavaweb.repository.jdbc.impl.DistrictJDBCImpl;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingConverter buildingConverter;

	@Autowired
	private BuildingResponseConverter buildingResponseConverter;

	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public Map<String, String> getDistricts() {
		Map<String, String> districts = new HashMap<>();
		for (DistrictsEnum item: DistrictsEnum.values()) {
			districts.put(item.toString(), item.getDistrictValue());
		}
		return districts;
	}

	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String> buildingTypes = new HashMap<>();
		for (BuildingTypesEnum item: BuildingTypesEnum.values()) {
			buildingTypes.put(item.toString(), item.getBuildingTypeValue());
		}
		return buildingTypes;
	}

	@Override
	@Transactional
	public BuildingDTO save(BuildingDTO newBuilding) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(newBuilding);
		return buildingConverter.convertToDTO(buildingRepository.save(buildingEntity));
	}
	
	@Override
	public List<BuildingResponseDTO> findByCondition(BuildingRequestDTO buildingRequest) {
		BuildingJDBCImpl buildingimpl = new BuildingJDBCImpl();
		DistrictJDBCImpl districtJDBC = new DistrictJDBCImpl();
		List<BuildingResponseDTO> result = new ArrayList<>();

		// call repo
        List<BuildingEntity> entities = buildingimpl.findByCondition(buildingRequest);

		// convert buildingEntity to BuildingResponseDTO
		for(BuildingEntity buildingEntity: entities){
			BuildingResponseDTO responseDTO = buildingResponseConverter.convertToDTO(buildingEntity);
			result.add(responseDTO);
		}
		return result;
	}

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> result = new ArrayList<>();
		List<BuildingEntity> entities = buildingRepository.findAll();
		for(BuildingEntity entity : entities){
			result.add(buildingConverter.convertToDTO(entity));
		}
		return result;
	}

}
