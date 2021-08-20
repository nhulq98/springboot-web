package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "district")// Quan hệ 1-n với đối tượng ở dưới (building) (1 địa điểm có nhiều building)
//    private List<BuildingEntity> buildings;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<BuildingEntity> getBuildings() {
//        return buildings;
//    }
//
//    public void setBuildings(List<BuildingEntity> buildings) {
//        this.buildings = buildings;
//    }
}
