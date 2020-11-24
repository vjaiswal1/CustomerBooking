package com.customerapplication.customerbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JourneyDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int journeyId;
	private int customerId;
	private String startDateTime;
	private String routeName;
	private double jorneyFare;

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public double getJorneyFare() {
		return jorneyFare;
	}

	public void setJorneyFare(double jorneyFare) {
		this.jorneyFare = jorneyFare;
	}

}
