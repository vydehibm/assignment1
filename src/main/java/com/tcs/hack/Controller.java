package com.tcs.hack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.hack.model.Booking;
import com.tcs.hack.model.Resource;
import com.tcs.hack.repository.BookingRepository;
import com.tcs.hack.repository.ResourceRepository;

@RestController
@RequestMapping("/tcs/hack/v1")
public class Controller {
	@Autowired 
	ResourceRepository resourceRepo;
	@Autowired 
	BookingRepository bookingRepo;
	@GetMapping(path = "/resources")
	public List<Resource> fetchAllResources() {
		return resourceRepo.findAll();
	}
	@RequestMapping(path = "/resources/{id}", method = RequestMethod.GET)
	public List<Resource> fetchSpecificResource(@PathVariable ("id") int id) {
		return resourceRepo.findByResourceId(id);
		
	}
	@PostMapping(path = "/resources")
	public String addNewResource(@RequestBody Resource resource) {
		resourceRepo.save(resource);
		return "Added new Resource!";	
	}
	
	@DeleteMapping(path = "/resources")
	public String deleteResource(@RequestBody Resource resource) {
		resourceRepo.delete(resource);
		return "Deleted a Resource!";	
	}
	
	@GetMapping(path = "/reservations")
	public List<Booking> fetchallReservations(){
		return bookingRepo.findAll();
	}
	/*
	 * @PostMapping(path = "/reservations") public String
	 * addReservation(@RequestBody Booking booking) { if
	 * ((findAvailability(booking.getBookingId(),booking.getBookingDate(),booking.
	 * getBookingSlot()))==1) { bookingRepo.save(booking); return
	 * "Equipment booking complete!"; } else { return
	 * "Equipment not available. Please try another day"; } } public int
	 * findAvailability(int resourceId, java.sql.Date date, String slot) { int
	 * equipmentsAvailable=0; List<Booking> currentReservation =
	 * bookingRepo.findAll(); for (Booking book: currentReservation) { if
	 * ((book.getBookingSlot()==slot) && book.getBookingDate()==date)
	 * equipmentsAvailable=0; else equipmentsAvailable=1; } return
	 * equipmentsAvailable; }
	 */
}