package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.DistrictDTO;
import com.laptrinhjavaweb.dto.RentTypeDTO;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.entity.RentTypeEntity;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentTypeConverter {

    @Autowired
    private ModelMapper modelMapper;

    public RentTypeDTO convertToDTO(RentTypeEntity entity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setSkipNullEnabled(true);
        RentTypeDTO dto = modelMapper.map(entity, RentTypeDTO.class);
        return dto;
    }

    public RentTypeEntity convertToEntity(RentTypeDTO dto) {
        RentTypeEntity entity = modelMapper.map(dto, RentTypeEntity.class);
        return entity;
    }
}
