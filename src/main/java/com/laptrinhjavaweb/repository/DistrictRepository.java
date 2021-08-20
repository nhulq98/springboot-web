package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
}
