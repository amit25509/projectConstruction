package com.project1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone",unique=true,nullable=false)
	private Integer phone;
	
	@Column(name = "password")
	private String password;

	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "email")
	private String email;

	public Users() {
	}

	public Users(Integer userId, String name, Integer phone, String password, String imageUrl, String location, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.imageUrl = imageUrl;
		this.location = location;
		this.email = email;
	}

	public Users(String name, Integer phone, String password, String imageUrl, String location, String email) {
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.imageUrl = imageUrl;
		this.location = location;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
//	@OneToOne(targetEntity = Address.class)
//	@JoinColumn(name="address", referencedColumnName = "addressId")
//	private Address addressId;
	
}
