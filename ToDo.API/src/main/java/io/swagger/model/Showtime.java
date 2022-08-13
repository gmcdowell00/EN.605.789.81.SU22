package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class for movie showtime
 * 
 * @author Yaser Albonni
 *
 */
public class Showtime {

	@JsonProperty("theatre")
	private String theatre;

	@JsonProperty("date")
	private String date;

	@JsonProperty("ticketURI")
	private String ticketURI;

	public String getTheatre() {
		return theatre;
	}

	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTicketURI() {
		return ticketURI;
	}

	public void setTicketURI(String ticketURI) {
		this.ticketURI = ticketURI;
	}
}
