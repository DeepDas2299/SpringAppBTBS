package com.mph.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Bus_Details")
/**
 * This Entity is for the Bus class
 * @author Divya G
 * @version 1.0
 */
public class Bus {
	@Id
	@GeneratedValue
	private long busId;
	@NotEmpty
	private String busName;
	@NotEmpty
	private String busType;

	@Valid
	@OneToMany(mappedBy = "bus", cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Seat> seats = new ArrayList<Seat>();

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Bus() {
		super();
	}

	public Bus(long busId, String busName, String busType) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busType = busType;
	}

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busType=" + busType + "]";
	}

}
