package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.DistrictEntity;
import org.springframework.stereotype.Repository;

public interface DistrictRepositoryCustom {
    DistrictEntity findById(Long id);
}
