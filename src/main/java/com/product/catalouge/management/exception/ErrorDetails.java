package com.product.catalouge.management.exception;

import java.util.Date;

/**
 * 
 * @author M1032933
 *
 */
public class ErrorDetails {
	  private Date timestamp;
	  private String message;
	  private String details;

	  public ErrorDetails(Date timestamp, String message, String details) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.details = details;
	 }
	  
}