package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.input.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BuildingDTO;

@Component
public class BuildingConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO convertToDTO(BuildingEntity entity) {
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STANDARD)
				.setSkipNullEnabled(true);
		BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
		dto.setAddress(dto.getStreet() +", "+ dto.getWard() +", "+dto.getDistrict());
		return dto;
	}

	public BuildingRequestDTO convertToRequestDTO(BuildingDTO buildingDTO) {
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STANDARD)
				.setSkipNullEnabled(true);
		BuildingRequestDTO requestDTO = modelMapper.map(buildingDTO, BuildingRequestDTO.class);
		return requestDTO;
	}

	public BuildingDTO convertResponseToDTO(BuildingResponseDTO responseDTO) {
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STANDARD)
				.setSkipNullEnabled(true);
		BuildingDTO dto = modelMapper.map(responseDTO, BuildingDTO.class);
		return dto;
	}
	
	public BuildingEntity convertToEntity(BuildingDTO dto) {
		BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
		return entity;
	}

}
