package com.example.RestfulDemo.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.RestfulDemo.Dao.TeacherDao;
import com.example.RestfulDemo.Model.*;
import com.example.RestfulDemo.Utils.*;
import com.mongodb.MongoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

	@Autowired
	TeacherDao teacherRepo;

	public TeacherService(TeacherDao teacherdao) {
		this.teacherRepo = teacherdao;
	}

	public List<Teacher> GetTeachers() {
		return teacherRepo.findAll();
	}

	public void CreateTeacher(Teacher teacher) {
		teacherRepo.insert(teacher);
	}

	public String CreateTeachers(List<Teacher> teachers) {

		return " ";
	}

	public String TestInsert(List<Teacher> teachers) {
		if (teachers == null) {

			// Instantiate teachers list
			teachers = new ArrayList<Teacher>();

			// Instantiate dateUtil object
			DateUtil dateUtil = new DateUtil();

			// Create two teachers and add them to list
			Calendar dobK = dateUtil.DetermineDateOfBirth(1988, 6, 18);
			Teacher kakakshi = new Teacher("Kakashi Hatake", "khatake@gmail.com", Constants.NINJUTSU, dobK,
					dateUtil.DetermineAge(dobK));
			Calendar dobG = dateUtil.DetermineDateOfBirth(1986, 7, 2);
			Teacher guy = new Teacher("Might Guy", "mguy@gmail.com", Constants.TAIJUTSU, dobG,
					dateUtil.DetermineAge(dobK));
			teachers.add(guy);
			teachers.add(kakakshi);
		}

		try {
			this.teacherRepo.insert(teachers);
			return teachers.size() + " inserted";
		} catch (MongoException e) {
			return "Could not save to databse.  The following error has occured: \n" + e.getMessage();
		}
	}
}
