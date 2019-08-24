package com.hermanramos.courses.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hermanramos.courses.models.Student;
import com.hermanramos.courses.services.LoginAndRegService;




@Controller
public class LoginAndRegCtrl {
	@Autowired
	LoginAndRegService lgS;
	
	@RequestMapping("/")
	public String loginAndReg(@ModelAttribute("student")Student student) {
		return "loginAndReg/loginAndReg.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("student") Student student, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "loginAndReg/loginAndReg.jsp";
		}else {
			lgS.registerStudent(student);
			session.setAttribute("student", student);
			return "redirect:/courses";
		}
	}
	
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("student") Student student, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        if(lgS.authenticateUser(email, password) == false) {
        	model.addAttribute("error", "Email or password not found");
        	return "loginAndReg/loginAndReg.jsp";
        } else if (lgS.authenticateUser(email, password) == true) {
        		Student foundStudent = lgS.findByEmail(email);
        		session.setAttribute("student", foundStudent);
        	}
        	return "redirect:/courses";
        }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("student");
    	return "redirect:/";
    }
    
}
