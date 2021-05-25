package com.mph.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Entity is for the Discount class
 * @author Divya G
 * @version 1.0
 */
@Entity
public class Discount {
	@Id
	@GeneratedValue
	private long discountId;
	private long busId;
	private double price;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date discountStartDate;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date discountEndDate;
	
	public Discount() {
	}

	public Discount(long discountId, long busId, double price,  Date discountStartDate, Date discountEndDate) {
		super();
		this.discountId = discountId;
		this.busId = busId;
		this.price = price;
		this.discountStartDate = discountStartDate;
		this.discountEndDate = discountEndDate;
	}

	public long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(long discountId) {
		this.discountId = discountId;
	}

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public Date getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(Date discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	public Date getDiscountEndDate() {
		return discountEndDate;
	}

	public void setDiscountEndDate(Date discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
