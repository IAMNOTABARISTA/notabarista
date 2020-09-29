package com.helloworld.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helloworld.app.dao.StudentRepo;
import com.helloworld.app.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentRepo repo;

	@RequestMapping("/")
	public String home() {
		return "Home.jsp";
	}

	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		repo.save(student);
		return "Home.jsp";
	}
}
