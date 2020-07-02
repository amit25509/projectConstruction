package com.project1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bookings")
public class Bookings 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_SEQ")
	@SequenceGenerator(name = "BOOKING_SEQ", sequenceName = "BOOKING_SEQ", allocationSize = 1 )
	private Integer bookingId;
	
	@Column(name = "bookingFrom",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" ,nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingFrom;
	
	@Column(name = "bookingTo",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP" ,nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingTo;
	
	@Column(name="status")
	private String status;
	
	@Column(name="days_worked")
	private Integer daysWorked;
	
	@OneToOne(targetEntity = Users.class)
	@JoinColumn(name="user_id", referencedColumnName = "userId")
	private Users userId;
	
	@OneToOne(targetEntity = Employees.class)
	@JoinColumn(name="employee_id", referencedColumnName = "employeeId")
	private Employees employeeId;

	public Bookings() {
	}

	public Bookings(Date bookingFrom, Date bookingTo, String status, Integer daysWorked, Users user,
			Employees employee) {
		super();
		this.bookingFrom = bookingFrom;
		this.bookingTo = bookingTo;
		this.status = status;
		this.daysWorked = daysWorked;
		this.userId = user;
		this.employeeId = employee;
	}
	
	public Bookings(Integer bookingId, Date bookingFrom, Date bookingTo, String status, Integer daysWorked, Users user,
			Employees employee) {
		super();
		this.bookingId = bookingId;
		this.bookingFrom = bookingFrom;
		this.bookingTo = bookingTo;
		this.status = status;
		this.daysWorked = daysWorked;
		this.userId = user;
		this.employeeId = employee;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingFrom() {
		return bookingFrom;
	}

	public void setBookingFrom(Date bookingFrom) {
		this.bookingFrom = bookingFrom;
	}

	public Date getBookingTo() {
		return bookingTo;
	}

	public void setBookingTo(Date bookingTo) {
		this.bookingTo = bookingTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(Integer daysWorked) {
		this.daysWorked = daysWorked;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Employees getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employees employeeId) {
		this.employeeId = employeeId;
	}

//	@OneToOne(mappedBy="addressId")
//	private Employees employees;
	
//	@OneToOne(mappedBy="addressId")
//	private Users users;

}
