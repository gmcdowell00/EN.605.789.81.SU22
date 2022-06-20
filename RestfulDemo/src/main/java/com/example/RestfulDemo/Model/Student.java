package com.example.RestfulDemo.Model;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("student")
public class Student {
	@Id
	private String id;
	@Field
	private String name;
	@Field
	private String email;
	//@Field
	private Calendar dob;
	private int age;
	
	public Student() {
		
	}
	
	public Student(String name, String email, Calendar dob, int age) {
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
	public String getId() {
		return this.id;
	}
	
}
