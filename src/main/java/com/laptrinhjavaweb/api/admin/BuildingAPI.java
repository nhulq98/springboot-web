package com.laptrinhjavaweb.api.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingResponseDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IDistrictService;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@Autowired
	private IBuildingService buildingService;
	
	@Autowired
	private IDistrictService districtService;
	
	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
		return buildingService.save(newBuilding);
	}

//	@GetMapping
//	public @ResponseBody List<BuildingDTO> findByCondition(@RequestBody BuildingCondition buildingCondition) {
//		return buildingService.findByCondition(buildingCondition);
//	}

	@GetMapping
	public @ResponseBody List<BuildingResponseDTO> findByCondition(@RequestParam Map<String, String> requestParam) {
		ObjectMapper mapper = new ObjectMapper();
		BuildingRequestDTO buildingRequest = mapper.convertValue(requestParam, BuildingRequestDTO.class);
		
		return buildingService.findByCondition(buildingRequest);
	}
}
