package com.hermanramos.courses.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hermanramos.courses.models.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{
	Student findByEmail(String email);
}
