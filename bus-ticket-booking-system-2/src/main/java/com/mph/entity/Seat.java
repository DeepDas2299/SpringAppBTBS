package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This Entity is for the Seat class
 * @author Divya G
 * @version 1.0
 */
@Entity
public class Seat {
	@Id
	@GeneratedValue
	private long seatNo;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "busID", referencedColumnName = "busId")
	private Bus bus;

	public Seat() {
		super();
	}

	public Seat(long seatNo, Bus bus) {
		super();
		this.seatNo = seatNo;
		this.bus = bus;
	}

	public long getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(long seatNo) {
		this.seatNo = seatNo;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	@Override

	public boolean equals(Object arg0) {
		return ((this.seatNo == ((Seat) arg0).seatNo));
	}

	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + "]";
	}
	@Override
	public int hashCode() {
		int hash = 5;
        hash = (int) (89 * hash + (this.seatNo >= 0 ? this.seatNo: 0));
        hash = 89 * hash + (int) (this.seatNo ^ (this.seatNo >>> 32));
        hash = (int) (89 * hash + this.seatNo);
        return hash;



	}
}
