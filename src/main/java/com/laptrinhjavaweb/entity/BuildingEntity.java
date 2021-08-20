package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
    
    @Column(name = "numberofbasement")
    private Integer numberOfBasement;
	
    @Column(name = "street")
    private String street;

    @Column(name = "ward")
	private String ward;

	@Column(name = "districtid")
	private Long districtId;

//	@ManyToOne
//	@JoinColumn(name = "districtid", nullable = false)// thông qua khóa ngoại districtid
//	private DistrictEntity district;

	// @OneToMany đọc là: @ 1 entity(this class) To many entity(below variable)
//	@OneToMany(mappedBy = "building")// Quan hệ 1-n với đối tượng ở dưới (RentErea) (1 building có nhiều rentErea)
//	private List<RentEreaEntity> rentEreas = new ArrayList<>();

    @Column(name = "floorarea")
    private Long floorArea;

    @Column(name = "rentprice")
	private Long rentPrice;

    @Column(name = "managername")
	private String managerName;

    @Column(name = "managerphone")
	private String managerPhone;

	@Column(name = "servicefee")
	private Integer serviceFee;

	public Integer getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

//	public DistrictEntity getDistrict() {
//		return district;
//	}
//
//	public void setDistrict(DistrictEntity district) {
//		this.district = district;
//	}

//	public List<RentEreaEntity> getRentEreas() {
//		return rentEreas;
//	}
//
//	public void setRentEreas(List<RentEreaEntity> rentEreas) {
//		this.rentEreas = rentEreas;
//	}


	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
}
