package com.tcs.hack.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tcs.hack.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{
	@Query(value = "select COUNT(booking) from Booking booking where booking.resource.resourceId = :resource" +
	           " and booking.bookingDate = :bookingDate and booking.bookingSlot = :bookingSlot ")
	public int findAvailability(@Param("resource") int resource, @Param("bookingDate")
    java.sql.Date bookingDate, @Param("bookingSlot")  String bookingSlot);
	List<Booking> findAll();
	List<Booking> findByBookingDate(Date date);
	
}
