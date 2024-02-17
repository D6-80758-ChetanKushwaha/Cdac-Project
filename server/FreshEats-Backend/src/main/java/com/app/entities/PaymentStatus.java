package com.app.entities;

public enum PaymentStatus {
	 	PENDING("Pending"),
	    COMPLETED("Completed"),
	    FAILED("Failed"),
	    REFUNDED("Refunded");

	    private final String status;

	    PaymentStatus(String status) {
	        this.status = status;
	    }

	    public String getStatus() {
	        return this.status;
	    }

}
