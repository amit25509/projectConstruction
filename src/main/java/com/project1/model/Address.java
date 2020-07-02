package com.project1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
	@SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
	private Integer addressId;
	
	@Column(name = "building_name")
	private String buildingName;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private Integer postalCode;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "street")
	private String street;
	
	public Address() {}
	
	public Address(Integer addressId, String buildingName, String city, Integer postalCode, String state, String street) {
		super();
		this.addressId = addressId;
		this.buildingName = buildingName;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.street = street;
	}
	
	public Address(String buildingName, String city, Integer postalCode, String state, String street) {
		super();
		this.buildingName = buildingName;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.street = street;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	
	
//	@OneToOne(mappedBy="addressId")
//	private Employees employees;
	
//	@OneToOne(mappedBy="addressId")
//	private Users users;

}
