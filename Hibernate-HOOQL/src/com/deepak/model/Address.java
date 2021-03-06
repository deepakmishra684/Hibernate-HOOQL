package com.deepak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author deepak
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADD_ID")
	private long id;

	@Column(name = "EMP_ID")
	private long empId;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	public Address() {
		super();
	}

	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	public Address(long empId, String city, String state) {
		super();
		this.empId = empId;
		this.city = city;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}