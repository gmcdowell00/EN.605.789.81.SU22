package com.example.RestfulDemo.Model;

import java.util.List;

public class Item {

	private List<Double> position;
	private Double distance;
	private String title;
	private Double averageRating;
	private Category category;
	private String icon;
	private String vicinity;
	private List<String> having;
	private String type;
	private String href;
	private String id;
	private OpeningHours openingHours;
	public List<Double> getPosition() {
		return position;
	}
	public void setPosition(List<Double> position) {
		this.position = position;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	public List<String> getHaving() {
		return having;
	}
	public void setHaving(List<String> having) {
		this.having = having;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OpeningHours getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}
	
	
}
