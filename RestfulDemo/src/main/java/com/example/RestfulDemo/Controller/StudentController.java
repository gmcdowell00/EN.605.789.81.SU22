package com.example.RestfulDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestfulDemo.Model.Student;
import com.example.RestfulDemo.Service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;



@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/find")
	public List<Student> getStudents() {
		return studentService.GetStudents();
	}
	
	@PostMapping(value="/create" , produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> create(@RequestBody Student student) throws JsonMappingException, JsonProcessingException  {
		
		Student createdStudent = this.studentService.CreateStudent(student);
		if (createdStudent != null) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("*** New Student Created *****" + System.lineSeparator());
			sb.append("Name: " + createdStudent.getName() + System.lineSeparator());
			sb.append("Age: " + createdStudent.getAge() + System.lineSeparator());
			sb.append("Email: " + createdStudent.getEmail() + System.lineSeparator());
			
			return ResponseEntity.ok(sb.toString());
		} else {
			return ResponseEntity.notFound().build();
		}
				
		
	}
}
