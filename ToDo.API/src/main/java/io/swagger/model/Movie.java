package io.swagger.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class for Movie response
 * 
 * @author Yaser Albonni
 *
 */
public class Movie {

	@JsonProperty("title")
	private String title;

	@JsonProperty("releaseYear")
	private String releaseYear;

	@JsonProperty("releaseDate")
	private String releaseDate;

	@JsonProperty("genres")
	private List<String> genres;

	@JsonProperty("description")
	private String description;

	@JsonProperty("showtimes")
	private List<Showtime> showtimes;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
}
