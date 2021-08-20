package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.DistrictConverter;
import com.laptrinhjavaweb.dto.DistrictDTO;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;
import com.laptrinhjavaweb.repository.jdbc.impl.BuildingJDBCImpl;
import com.laptrinhjavaweb.repository.jdbc.impl.DistrictJDBCImpl;
import com.laptrinhjavaweb.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Component
public class DistrictService implements IDistrictService {

    @Autowired
    private DistrictConverter districtConverter;

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<DistrictDTO> getDistricts() {
        List<DistrictDTO> result = new ArrayList<>();
        List<DistrictEntity> entities = districtRepository.findAll();
        for(DistrictEntity districtEntity: entities){
            result.add(districtConverter.convertToDTO(districtEntity));
        }
        return result;
    }

    @Override
    public List<DistrictDTO> findAll() {
        List<DistrictDTO> result = new ArrayList<>();
        DistrictJDBCImpl districtJDBC = new DistrictJDBCImpl();
        List<DistrictEntity> entities = districtJDBC.findAll();
        for(DistrictEntity entity: entities){
            DistrictDTO districtDTO = new DistrictDTO();
            districtDTO.setName(entity.getName());
            districtDTO.setId(entity.getId());
            result.add(districtDTO);
        }
        return result;
    }
}
