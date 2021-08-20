package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.DistrictDTO;
import com.laptrinhjavaweb.entity.DistrictEntity;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictConverter {

    @Autowired
    private ModelMapper modelMapper;

    public DistrictDTO convertToDTO(DistrictEntity entity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setSkipNullEnabled(true);
        DistrictDTO dto = modelMapper.map(entity, DistrictDTO.class);
        return dto;
    }

    public DistrictEntity convertToEntity(DistrictDTO dto) {
        DistrictEntity entity = modelMapper.map(dto, DistrictEntity.class);
        return entity;
    }

}
