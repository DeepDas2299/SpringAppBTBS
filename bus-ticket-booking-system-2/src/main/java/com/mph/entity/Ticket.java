package com.mph.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * This Entity is for the Ticket class
 * @author Divya G
 * @version 1.0
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ticketId")
public class Ticket {
	@Id
	@GeneratedValue
	private long ticketId;
	@NotEmpty
	private String busName;
	@NotEmpty
	private String bookingTime;
	@NotNull
	private Float price;
	@Min(value = 1)
	@Max(value = 6)
	private int seatsBooked;
	@NotEmpty
	private String pickupPoint;
	@NotEmpty
	private String dropPoint;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date pickupTime;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dropTime;
	@ElementCollection(fetch = FetchType.EAGER)

	private Set<Passenger> passengers = new HashSet<Passenger>();
	@ManyToOne
	private User user;
	@ManyToOne
	private JourneyDetails journey;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Long> bookedSeats = new HashSet<Long>();

	public Ticket() {
		super();
	}

	public Ticket(long ticketId, String busName, String bookingTime, Float price, int seatsBooked, String pickupPoint,
			String dropPoint, Date pickupTime, Date dropTime, Set<Passenger> passengers, User user,
			Set<Long> bookedSeats) {
		super();
		this.ticketId = ticketId;
		this.busName = busName;
		this.bookingTime = bookingTime;
		this.price = price;
		this.seatsBooked = seatsBooked;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.passengers = passengers;
		this.user = user;
		this.bookedSeats = bookedSeats;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getDropTime() {
		return dropTime;
	}

	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}

	public JourneyDetails getJourney() {
		return journey;
	}

	public void setJourney(JourneyDetails journey) {
		this.journey = journey;
	}

	public Set<Long> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Set<Long> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	@Override
	public boolean equals(Object arg0) {
		return (this.ticketId==((Ticket) arg0).ticketId);
	}

	@Override
	public int hashCode() {
		return 5;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", busName=" + busName + ", bookingTime=" + bookingTime + ", price="
				+ price + ", seatsBooked=" + seatsBooked + ", pickupPoint=" + pickupPoint + ", dropPoint=" + dropPoint
				+ ", pickupTime=" + pickupTime + ", dropTime=" + dropTime + ", passengers=" + passengers + ", user="
				+ user.getUid() + ", journey=" + journey.getJourneyID() + ", bookedSeats=" + bookedSeats + "]";
	}

}
