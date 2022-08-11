package com.example.RestfulDemo.Model;

import java.util.List;

public class Results {

	public String next;
	public List<Item> items;
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
