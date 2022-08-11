package com.example.RestfulDemo.Utils;

import java.util.Calendar;

public class DateUtil {

	public int DetermineAge(Calendar dob) {
		Calendar current = Calendar.getInstance();
		return current.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
	}
	
	public Calendar DetermineDateOfBirth(int year, int month, int day) {
		Calendar dob = Calendar.getInstance();
		dob.set(year, month, day);
		return dob;
	}
		
}
