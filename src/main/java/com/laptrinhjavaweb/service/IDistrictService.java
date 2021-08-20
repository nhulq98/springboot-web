package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.DistrictDTO;

import java.util.List;

public interface IDistrictService {
    List<DistrictDTO> getDistricts();
    List<DistrictDTO> findAll();
}
