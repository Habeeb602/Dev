package com.learnspringboot.restwebservices.util;

import java.time.LocalDateTime;

public class ErrorDetails {
	LocalDateTime timestamp;
	String errorMessage;
	String details;
	
	
	public ErrorDetails(LocalDateTime timestamp, String errorMessage, String details) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.details = details;
	}
	
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
