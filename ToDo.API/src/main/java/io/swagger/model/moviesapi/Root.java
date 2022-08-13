package io.swagger.model.moviesapi;

import java.util.ArrayList;

/**
 * Model class for movie root object
 * 
 * @author Yaser Albonni
 *
 */
public class Root {

	public String tmsId;
	public String rootId;
	public String sportsId;
	public String subType;
	public String title;
	public String releaseYear;
	public String releaseDate;
	public String titleLang;
	public String descriptionLang;
	public String entityType;
	public ArrayList<String> genres;
	public String longDescription;
	public String shortDescription;
	public ArrayList<String> topCast;
	public ArrayList<String> directors;
	public String officialUrl;
	public QualityRating qualityRating;
	public ArrayList<Rating> ratings;
	public ArrayList<String> advisories;
	public String runTime;
	public String audience;
	public String animation;
	public String holiday;
	public PreferredImage preferredImage;
	public ArrayList<Showtime> showtimes;

}
