package com.tcs.hack.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.hack.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{
	public int findAvailability(int resourceId, java.sql.Date date, String slot);
}
