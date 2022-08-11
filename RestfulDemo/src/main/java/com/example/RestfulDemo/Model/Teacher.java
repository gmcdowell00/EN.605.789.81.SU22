package com.example.RestfulDemo.Model;

import java.util.Calendar;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("teacher")
public class Teacher {
	@Id
	private ObjectId id;
	@Field
	private String name;
	@Field
	private String email;
	@Field
	private Calendar dob;
	@Field
	private String Course;
	@Field
	private int age;
	
	public Teacher() {
		
	}
	
	public Teacher(String name, String email, String course, Calendar dob, int age) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDob() {
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	
}
