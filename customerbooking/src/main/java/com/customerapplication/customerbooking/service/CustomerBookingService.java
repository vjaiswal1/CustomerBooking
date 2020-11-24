package com.customerapplication.customerbooking.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerapplication.customerbooking.entity.Customer;
import com.customerapplication.customerbooking.entity.JourneyDetails;
import com.customerapplication.customerbooking.entity.Route;
import com.customerapplication.customerbooking.repository.CustomerRepository;
import com.customerapplication.customerbooking.repository.JourneyRepository;
import com.customerapplication.customerbooking.repository.RouteRepository;
import com.customerapplication.customerbooking.utility.CustomerType;

@Service
public class CustomerBookingService {

	@Autowired
	RouteRepository repo;

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	JourneyRepository journeyRepo;

	public int addRoute(Route route) {
		return repo.save(route).getRouteId();

	}

	public int addCustomer(Customer customer) {
		return customerRepo.save(customer).getCustomerId();

	}

	public JourneyDetails addJorneyDetails(JourneyDetails journeyDetails) throws Exception {

		isTimeStampValid(journeyDetails.getStartDateTime());
		journeyDetails.setJorneyFare(calculateFareForCustomerType(journeyDetails));

		return journeyRepo.save(journeyDetails);

	}

	private double calculateAdditionalDiscountOnFare(JourneyDetails journeyDetails) {
		double currentFare;
		currentFare = journeyDetails.getJorneyFare();

		List<Object> object = journeyRepo.findLastJorneyDetails();
		if (object.contains(journeyDetails.getCustomerId())) {
			return currentFare = .9 * currentFare;

		}
		return currentFare;

	}

	private double calculateFareForCustomerType(JourneyDetails journeyDetails) {
		Optional<Customer> c = customerRepo.findById(journeyDetails.getCustomerId());
		double fare;
		if (c.get().getCustomerType().equalsIgnoreCase(CustomerType.VIP.toString())) {
			fare = 1;
			if (c.get().getFavRoute().equalsIgnoreCase(journeyDetails.getRouteName())) {
				fare = .7 * fare;
			
			}
			journeyDetails.setJorneyFare(fare);
			fare = calculateAdditionalDiscountOnFare(journeyDetails);
		} 
		
		
		
		else if (c.get().getCustomerType().equalsIgnoreCase(CustomerType.NORMAL.toString())) {
			fare = 2;
			if (c.get().getFavRoute().equalsIgnoreCase(journeyDetails.getRouteName())) {
				fare = .7 * fare;
				
				
			}
			journeyDetails.setJorneyFare(fare);
			fare = calculateAdditionalDiscountOnFare(journeyDetails);
		} 
		
		else {
			fare = 2;
		}

		return fare;
	}

	
	public static boolean isTimeStampValid(String inputString) throws Exception
	{ 
	    SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    try{
	       format.parse(inputString);
	       return true;
	    }
	    catch(Exception e)
	    {
	       throw new Exception("Please Provide valid startDateTime Value in the format 'yyyy-MM-dd HH:mm:ss'");
	    }
	}
}
