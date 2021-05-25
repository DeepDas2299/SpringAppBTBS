package com.mph.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This model is for the Address class
 * @author Divya G
 * @version 1.0
 */
@Embeddable
public class Address {

	@NotEmpty(message="street name cannot be empty")
	private String streetName;
	@NotEmpty(message="city cannot be empty")
	private String city;
	@NotEmpty(message="state cannot be empty")
	private String state;
	private long zipcode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String streetName, String city, String state, long zipcode) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
}
