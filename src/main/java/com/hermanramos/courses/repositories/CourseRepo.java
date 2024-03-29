package com.hermanramos.courses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hermanramos.courses.models.Course;

public interface CourseRepo extends CrudRepository<Course, Long>{
	List<Course> findAll();

}
