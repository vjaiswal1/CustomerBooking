package com.customerapplication.customerbooking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customerapplication.customerbooking.controller.CustomerBookingController;
import com.customerapplication.customerbooking.entity.Customer;
import com.customerapplication.customerbooking.entity.JourneyDetails;
import com.customerapplication.customerbooking.entity.Route;
import com.customerapplication.customerbooking.utility.CustomerType;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerBookingJunitTest {
	@Autowired
	CustomerBookingController controller;

	@Test
	public void testAddRoute() {
		Route route = new Route();
		route.setDestination("Indore");
		route.setSource("Manpur");
		route.setRouteName("Manpur-Indore");

		ResponseEntity<Integer> entity = controller.addRoute(route);

		assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setCustomerType(CustomerType.VIP.toString());
		customer.setCustomerName("Vikas");
		customer.setFavRoute("Manpur-Indore");

		ResponseEntity<Integer> entity = controller.addCustomer(customer);

		assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	}

	@Test
	public void testAddJourneyDetails() {
		JourneyDetails journeyDetails = new JourneyDetails();
		journeyDetails.setCustomerId(1);
		journeyDetails.setStartDateTime("24-11-2020");
		journeyDetails.setRouteName("Manpur-Indore");
		ResponseEntity<JourneyDetails> entity = controller.addJorney(journeyDetails);
		assertEquals(HttpStatus.CREATED, entity.getStatusCode());
	}

	@Test
	public void testCalculatrJourneyFare() {
		JourneyDetails journeyDetails = new JourneyDetails();
		journeyDetails.setCustomerId(1);
		journeyDetails.setStartDateTime("24-11-2020");
		journeyDetails.setRouteName("Manpur-Indore");
		ResponseEntity<JourneyDetails> entity = controller.addJorney(journeyDetails);
		assertEquals(.7, entity.getBody().getJorneyFare(), 0.0);
	}

}
