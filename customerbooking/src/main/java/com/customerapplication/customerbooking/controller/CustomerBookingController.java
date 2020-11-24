package com.customerapplication.customerbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerapplication.customerbooking.entity.Customer;
import com.customerapplication.customerbooking.entity.JourneyDetails;
import com.customerapplication.customerbooking.entity.Route;
import com.customerapplication.customerbooking.service.CustomerBookingService;

@RestController
public class CustomerBookingController {

	@Autowired
	CustomerBookingService service;

	@PostMapping(value = "/addRoute")
	public ResponseEntity<Integer> addRoute(@RequestBody Route route) {
		try {
			int routeID = service.addRoute(route);

			return new ResponseEntity<>(routeID, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(value = "/addCustomer")
	public ResponseEntity<Integer> addCustomer(@RequestBody Customer customer) {
		try {
			int customerID = service.addCustomer(customer);

			return new ResponseEntity<>(customerID, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(value = "/addJourney")
	public ResponseEntity<JourneyDetails> addJorney(@RequestBody JourneyDetails journeyDetails) throws Exception {
			JourneyDetails journey = service.addJorneyDetails(journeyDetails);

			return new ResponseEntity<>(journey, HttpStatus.CREATED);
		

	}
}
