package com.example.RestfulDemo.Service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestfulDemo.Dao.StudentDao;
import com.example.RestfulDemo.Model.Student;

@Service
public class StudentService {
	
	public final StudentDao studentRepo;
	
	@Autowired
	public StudentService(StudentDao studentRepo) {
		this.studentRepo = studentRepo;
	}

	public List<Student> GetStudents()
	{
		return this.studentRepo.findAll();
	}
	
	public Student CreateStudent(Student student) {
		studentRepo.insert(student);
		Student createdStudent = studentRepo.findByName(student.getName());
		return createdStudent; 
	}
	
	/*
	private List<Student> GetTestStudents(){
		Calendar dobT = Calendar.getInstance();
		dobT.set(1998, 6, 12);
		
		Calendar dobN = Calendar.getInstance();
		dobN.set(1998, 5, 12);
		
		Calendar cal = Calendar.getInstance();		    

		return List.of(
				new Student("Tom Holland", "tholland@gmail.com", dobT, cal.get(Calendar.YEAR) - dobT.get(Calendar.YEAR)),
				new Student("Ned Leeds", "nedleeds@gmail.com", dobN, cal.get(Calendar.YEAR) - dobN.get(Calendar.YEAR))
				);
	}
	*/
}
