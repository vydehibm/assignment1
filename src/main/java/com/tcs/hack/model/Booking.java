package com.tcs.hack.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

	
	private int bookingId;
	@Column(nullable=false)
	private Date bookingDate;
	
	private String bookingSlot;
	
	private Resource resource;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingSlot() {
		return bookingSlot;
	}
	public void setBookingSlot(String bookingSlot) {
		this.bookingSlot = bookingSlot;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Date getBookingDate() {
		return (Date) bookingDate.clone();
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate!=null?(Date) bookingDate.clone():null;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingSlot=" + bookingSlot + ", resource=" + resource + "]";
	}
	
	
	
	
}