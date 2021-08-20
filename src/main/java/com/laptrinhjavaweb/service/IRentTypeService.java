package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.RentTypeDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IRentTypeService {
    List<RentTypeDTO> getRentTypes();
}
