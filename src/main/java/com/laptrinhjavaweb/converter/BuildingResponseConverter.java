package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.output.BuildingResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.jdbc.impl.DistrictJDBCImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingResponseConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingResponseDTO convertToDTO(BuildingEntity entity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD) // apply mapper type Standard(Các mức độ mapping)
                .setSkipNullEnabled(true);// skip value null --> skip null pointer error
        BuildingResponseDTO dto = modelMapper.map(entity, BuildingResponseDTO.class);
        DistrictJDBCImpl districtJDBC = new DistrictJDBCImpl();
        dto.setAddress(entity.getStreet() +", "+ entity.getWard() +", "+districtJDBC.findById(entity.getDistrictId()).getName());
        return dto;
    }

    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
        return entity;
    }
}
