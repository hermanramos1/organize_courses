package com.hermanramos.courses.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hermanramos.courses.models.StudentCourse;

public interface StudentCourseRepo extends CrudRepository <StudentCourse, Long> {
	
}
