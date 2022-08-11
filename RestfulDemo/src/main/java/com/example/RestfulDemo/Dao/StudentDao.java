package com.example.RestfulDemo.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.RestfulDemo.Model.Student;

public interface StudentDao extends MongoRepository<Student, String> {
	
	@Query("{name: '?0'}")
	Student findByName(String name);
}
