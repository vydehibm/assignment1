package com.tcs.hack.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	public Booking () {}
	public Booking(int bookingId, Date bookingDate, String bookingSlot, Resource resource) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingSlot = bookingSlot;
		this.resource = resource;
	}
	@Id
	@Column(name="booking_id")
	private int bookingId;
	@Column(nullable=false, name="booking_date")
	private Date bookingDate;
	@Column(name="booking_slot")
	private String bookingSlot;
	
	@JoinColumn(name = "resource_id", referencedColumnName = "resource_id")
    @OneToOne
//	@Column(name="resource_id")
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