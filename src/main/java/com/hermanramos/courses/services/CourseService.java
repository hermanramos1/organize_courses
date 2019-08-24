package com.hermanramos.courses.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hermanramos.courses.models.Course;
import com.hermanramos.courses.models.Student;
import com.hermanramos.courses.models.StudentCourse;
import com.hermanramos.courses.repositories.CourseRepo;
import com.hermanramos.courses.repositories.StudentCourseRepo;
import com.hermanramos.courses.repositories.StudentRepo;


@Service
public class CourseService {
	@Autowired 
	CourseRepo cR;
	@Autowired 
	StudentRepo sR;
	@Autowired 
	LoginAndRegService lgS;
	@Autowired 
	StudentCourseRepo scR;

	
	//create a course 
	public Course createCourse (Course course) {
		return cR.save(course);
	}
	//return all course 
	public List<Course> findAll() {
		return cR.findAll();
	}
	public Course findCourse(Long id) {
		Optional<Course> optionalCourse = cR.findById(id);
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		}else {
			return null;
		}
		
		
	}
	public void addCourseToStudent(Long courseId, Long studentId) {
		StudentCourse relationship = new StudentCourse();
		Student student = lgS.findUserById(studentId);
		Course course = findCourse(courseId);
		relationship.setStudent(student);
		relationship.setCourse(course);
		scR.save(relationship);
	}
	public void updateBook(Course course) {
		cR.save(course);	
	}
	public void deleteCourse(Long id) {
		cR.deleteById(id);
		
	}

}
