package com.tcs.hack;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.hack.dto.BookingDTO;
import com.tcs.hack.dto.ReservationsDTO;
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
	public Resource fetchSpecificResource(@PathVariable("id") int id) {
		return resourceRepo.findByResourceId(id);

	}

	@PostMapping(path = "/resources")
	public String addNewResource(@RequestBody Resource resource) {
		resourceRepo.save(resource);
		return "Added new Resource!";
	}

	@DeleteMapping(path = "/resources")
	public ResponseEntity<String> deleteResource(@RequestBody Resource resource) {
		resourceRepo.delete(resource);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/reservations")
	public List<ReservationsDTO> fetchallReservations() {
		List<Booking> bookingList = bookingRepo.findAll();
		System.out.println(bookingList.size());
		List<ReservationsDTO> reservationsDTOs = new ArrayList<ReservationsDTO>();
		for (Booking booking : bookingList) {
			ReservationsDTO reservationsDTO = new ReservationsDTO();
			reservationsDTO.setBookingDate(booking.getBookingDate().toString());
			reservationsDTO.setBookingSlot(booking.getBookingSlot());
			reservationsDTO.setResourceName(booking.getResource().getResourceName());
			reservationsDTOs.add(reservationsDTO);
		}

		return reservationsDTOs;
	}
	
	  @PostMapping(path = "/reservations") 
	  public ResponseEntity<String> addReservation(@RequestBody BookingDTO bookingForm) throws ParseException 
	  {  
		  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		  Date bookingDate= new Date(df.parse(bookingForm.getBookingDate()).getTime());
		  System.out.println(bookingDate);
		  	int i=12;

		  if (bookingRepo.findAvailability(bookingForm.getResourceId(), bookingDate, bookingForm.getBookingSlot()) == 0)
			  {
			  
			  Resource resource = resourceRepo.findOne(bookingForm.getResourceId());
			  System.out.println(resource);
			  	bookingRepo.save(new Booking(i++,
			  			bookingDate, 
			  			bookingForm.getBookingSlot(),
			  			resource));
			  	return new ResponseEntity<>(HttpStatus.CREATED);
			  }
		  else {
			  bookingForm = null;
		  	  return new ResponseEntity<>("Resource not available", HttpStatus.OK) ;
		  }	  
	  }
	/*
	 * public int findAvailability(int resourceId, java.sql.Date date, String slot)
	 * { int EquipmentsAvailable=0; List<Booking> currentBookings =
	 * bookingRepo.findByBookingDate(date); for (Booking booking: currentBookings) {
	 * if ((resourceId == booking.getResource().getResourceId()) &&
	 * date==booking.getBookingDate() && slot == booking.getBookingSlot())
	 * EquipmentsAvailable=1; else EquipmentsAvailable=0; } return
	 * EquipmentsAvailable; }
	 */
}