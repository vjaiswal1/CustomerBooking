package com.customerapplication.customerbooking.utility;

import java.time.LocalDateTime;

public class ErrorResponse {

	private String errorMessage;
	private LocalDateTime dateTime;


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}