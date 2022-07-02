package com.example.RestfulDemo.Model;

import java.util.List;

public class OpeningHours {

	public String text;
	public String label;
	public boolean isOpen;
	public List<Structure> structured;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public List<Structure> getStructured() {
		return structured;
	}
	public void setStructured(List<Structure> structured) {
		this.structured = structured;
	}
	
}
