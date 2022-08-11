package com.example.RestfulDemo.Dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.example.RestfulDemo.Model.*;

@Component
public interface TeacherDao extends MongoRepository<Teacher, String>{

	@Query("{name: '?0'}")
	Teacher findByName(String name);
	
	@Query(value="{course:'?0'}")
	List<Teacher> findAllByCoursName(String course);
	
}
