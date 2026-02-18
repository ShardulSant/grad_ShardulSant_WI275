package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.h2.H2StudentRepo;
import com.example.demo.repo.postgres.PostgresStudentRepo;

@Controller
public class StudentController {
	@Autowired
	H2StudentRepo h2repo;
	
	@Autowired
	PostgresStudentRepo postgresqlrepo;
	
	@RequestMapping("/student")
	public String homeStudent() {
		return "student.jsp";
	}
	@RequestMapping("/addStudent")
	public String addStudent(Student s) {
		h2repo.save(s);
		postgresqlrepo.save(s);
		return "student.jsp";
	}
}
