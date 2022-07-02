package com.example.RestfulDemo.Model;

import java.util.List;

public class Location {

	private List<Double> position;
	private Address address;
	public List<Double> getPosition() {
		return position;
	}
	public void setPosition(List<Double> position) {
		this.position = position;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
