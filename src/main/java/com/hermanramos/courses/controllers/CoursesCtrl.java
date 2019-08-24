package com.hermanramos.courses.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hermanramos.courses.models.Course;
import com.hermanramos.courses.models.Student;
import com.hermanramos.courses.models.StudentCourse;
import com.hermanramos.courses.services.CourseService;






@Controller
public class CoursesCtrl {
	@Autowired
	CourseService cR;
	
	@RequestMapping("/courses")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("student") !=null) {
        	model.addAttribute("allCourses", cR.findAll());
			return "courses/dashboard.jsp";
		}else {
			return "redirect:/";
		}
		
	}
	@RequestMapping("/courses/new")
	public String displayAddForm(@ModelAttribute("courseObj") Course course) {
		return "courses/new.jsp";
	}
	
	@PostMapping("/courses")
	public String createCourse(@Valid@ModelAttribute("courseObj") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "courses/new.jsp";
		}else {
			cR.createCourse(course);
			return "redirect:/courses";
		}
	}
	
	@GetMapping("/courses/{courseId}")
	public String displayCourse(@PathVariable("courseId")Long id, Model model) {
		model.addAttribute("course", cR.findCourse(id));
		Course course = cR.findCourse(id);
		List<Student> studentList = course.getStudents();
		int studentNum = studentList.size();
		model.addAttribute("allStudents", studentList);
		model.addAttribute("studentNum", studentNum);
		return "courses/view.jsp";
	}
	
	@GetMapping("/courses/{courseId}/add")
	public String addCourseToStudent(@PathVariable("courseId")Long id, HttpSession session) {
		Student student = (Student) session.getAttribute("student");
		Long studentId = student.getId();
		Long courseId = id;
		cR.addCourseToStudent(courseId, studentId);
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/{courseId}/edit")
	public String editCourse(@PathVariable("courseId")Long id, Model model) {
		Course course = cR.findCourse(id);
		model.addAttribute("course", course);
		return "courses/edit.jsp";
	}
	
    @RequestMapping(value="/courses/{courseId}", method=RequestMethod.PUT)
    public String updateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "/courses/edit.jsp";
        } else {
            cR.updateBook(course);
            return "redirect:/courses";
        }
    }
    @RequestMapping("/courses/{courseId}/delete")
    public String deleteCourse(@PathVariable("courseId")Long id) {
    	cR.deleteCourse(id);
    	return "redirect:/courses";
    }
}





