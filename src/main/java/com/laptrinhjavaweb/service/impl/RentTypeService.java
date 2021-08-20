package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.RentTypeConverter;
import com.laptrinhjavaweb.dto.RentTypeDTO;
import com.laptrinhjavaweb.entity.RentTypeEntity;
import com.laptrinhjavaweb.repository.jdbc.impl.RentTypeJDBCImpl;
import com.laptrinhjavaweb.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RentTypeService implements IRentTypeService {

    @Autowired
    private RentTypeConverter rentTypeConverter;

    @Override
    public List<RentTypeDTO> getRentTypes() {
        List<RentTypeDTO> result = new ArrayList<>();
        RentTypeJDBCImpl rentTypeJDBC = new RentTypeJDBCImpl();
        List<RentTypeEntity> entities = rentTypeJDBC.findAll();
        for(RentTypeEntity entity: entities){
            //RentTypeDTO rentTypeDTO = rentTypeConverter.convertToDTO(rentTypeEntity);
            RentTypeDTO rentTypeDTO = new RentTypeDTO();
            rentTypeDTO.setId(entity.getId());
            rentTypeDTO.setName(entity.getName());
            rentTypeDTO.setCode(entity.getCode());
            result.add(rentTypeDTO);
        }
//        List<UserEntity> entities = userRepository.getStaffs();
//        for(UserEntity entity: entities){
//            UserDTO dto = userConverter.convertToDto(entity);
//            result.add(dto);
//        }

        return result;
    }
}
