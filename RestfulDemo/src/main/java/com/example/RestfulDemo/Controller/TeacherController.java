package com.example.RestfulDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestfulDemo.Model.Teacher;
import com.example.RestfulDemo.Service.TeacherService;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {

	@Autowired
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@GetMapping("/getAll")
	public List<Teacher> getAllTeachers() {
		return this.teacherService.GetTeachers();
	}
	
	
	@PostMapping("/createteachers")
	public String CreateTeachers () {
		return this.teacherService.CreateTeachers(null);
	}
}
