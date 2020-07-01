package com.project1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "employees")
public class Employees 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone",unique=false,nullable=false)
	private Integer phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "experience")
	private Integer experience;
	
	@Column(name = "is_Verified")
	private boolean isVerified;
	
	@Column(name = "occupation")
	private String occupation;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "availability")
	private boolean availability;
	
	@Column(name = "job_start_date",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" ,nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date jobStartDate;
	
	@Column(name = "aadhar_front")
	private String aadharFront;
	
	@Column(name = "aadhar_back")
	private String aadharBack;
	
	@Column(name = "commission_rate")
	private Integer commissionRate;
	
	@OneToOne(targetEntity = Locations.class)
	@JoinColumn(name="location_id", referencedColumnName = "locationId")
	private Locations locationId;

	public Employees() {
		super();
	}

	public Employees(Integer employeeId, String name, Integer phone, String email, Integer age, Integer experience,
			boolean isVerified, String occupation, String password, String image, boolean availability,
			Date jobStartDate, String aadharFront, String aadharBack, Integer commissionRate, Locations locationId) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.experience = experience;
		this.isVerified = isVerified;
		this.occupation = occupation;
		this.password = password;
		this.image = image;
		this.availability = availability;
		this.jobStartDate = jobStartDate;
		this.aadharFront = aadharFront;
		this.aadharBack = aadharBack;
		this.commissionRate = commissionRate;
		this.locationId = locationId;
	}

	public Employees(String name, Integer phone, String email, Integer age, Integer experience, boolean isVerified,
			String occupation, String password, String image, boolean availability, Date jobStartDate,
			String aadharFront, String aadharBack, Integer commissionRate, Locations locationId) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.experience = experience;
		this.isVerified = isVerified;
		this.occupation = occupation;
		this.password = password;
		this.image = image;
		this.availability = availability;
		this.jobStartDate = jobStartDate;
		this.aadharFront = aadharFront;
		this.aadharBack = aadharBack;
		this.commissionRate = commissionRate;
		this.locationId = locationId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Date getJobStartDate() {
		return jobStartDate;
	}

	public void setJobStartDate(Date jobStartDate) {
		this.jobStartDate = jobStartDate;
	}

	public String getAadharFront() {
		return aadharFront;
	}

	public void setAadharFront(String aadharFront) {
		this.aadharFront = aadharFront;
	}

	public String getAadharBack() {
		return aadharBack;
	}

	public void setAadharBack(String aadharBack) {
		this.aadharBack = aadharBack;
	}

	public Integer getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(Integer commissionRate) {
		this.commissionRate = commissionRate;
	}

	public Locations getLocationId() {
		return locationId;
	}

	public void setLocationId(Locations locationId) {
		this.locationId = locationId;
	}


}