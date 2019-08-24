package com.hermanramos.courses.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hermanramos.courses.models.Student;
import com.hermanramos.courses.repositories.StudentRepo;


@Service
public class LoginAndRegService {
	@Autowired 
	StudentRepo uR;
	
	// register user and hash their password
    public Student registerStudent(Student student) {
        String hashed = BCrypt.hashpw(student.getPassword(), BCrypt.gensalt());
        student.setPassword(hashed);
        return uR.save(student);
    }
    
    // find user by email
    public Student findByEmail(String email) {
        return uR.findByEmail(email);
    }
    
    // find user by id
    public Student findUserById(Long id) {
    	Optional<Student> u = uR.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    

    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
    	Student student = uR.findByEmail(email);
        // if we can't find it by email, return false
        if(student == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, student.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
