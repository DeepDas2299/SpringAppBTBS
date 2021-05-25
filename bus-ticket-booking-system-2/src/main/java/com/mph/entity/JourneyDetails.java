package com.mph.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * This Entity is for the JourneyDetails class
 * @author Divya G
 * @version 1.0
 */
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "journeyID")
public class JourneyDetails {
	@Id
	@GeneratedValue
	private long journeyID;
	@Valid
	@OneToOne
	@JoinColumn(name = "BusID")
	private Bus bus;
	@NotEmpty(message="source cannot be empty")
	private String source;
	@NotEmpty(message="dest cannot be empty")
	private String dest;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date journeyDate;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(name = "JourneyPickupDetails")
	private Map<String, String> pickupDetails = new HashMap<String, String>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(name = "JourneyDropDetails")
	private Map<String, String> dropDetails = new HashMap<String, String>();
	
	@Min(value=0)
	private int availableSeats;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Long> bookedSeats = new HashSet<Long>();

	public JourneyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JourneyDetails(long journeyID, Bus bus, String source, String dest, String deptTime, String arrTime,
			int availableSeats, Date date) {
		super();
		this.journeyID = journeyID;
		this.bus = bus;
		this.source = source;
		this.dest = dest;
		this.availableSeats = availableSeats;
		this.journeyDate = date;
	}

	public long getJourneyID() {
		return journeyID;
	}

	public void setJourneyID(long journeyID) {
		this.journeyID = journeyID;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Map<String, String> getPickupDetails() {
		return pickupDetails;
	}

	public void setPickupDetails(Map<String, String> pickupDetails) {
		this.pickupDetails = pickupDetails;
	}

	public Map<String, String> getDropDetails() {
		return dropDetails;
	}

	public void setDropDetails(Map<String, String> dropDetails) {
		this.dropDetails = dropDetails;
	}

	public Set<Long> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Set<Long> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	@Override
	public boolean equals(Object arg0) {
		return (this.journeyID == ((JourneyDetails) arg0).journeyID);
	}

	@Override
	public int hashCode() {
		int hash = 5;
        hash = (int) (89 * hash + (this.availableSeats >= 0 ? this.availableSeats: 0));
        hash = 89 * hash + (int) (this.availableSeats ^ (this.availableSeats >>> 32));
        hash = (int) (89 * hash + this.availableSeats);
        return hash;
	}
}
