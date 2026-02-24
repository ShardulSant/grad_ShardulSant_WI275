package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmpRepo;
import com.example.demo.service.EmployeeService;

@RestController
public class EmpController {

	@Autowired
	EmployeeService service;

	@GetMapping("employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return service.findEmpById(id);
	}
	
	
	
	
	
	/*
	  
	@Autowired
	EmpRepo repo;
	@GetMapping("/")
	public String greet() {
		return "<h2> Hello ABC </h2>";
	}
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.getEmployee(); 
	}
	@GetMapping("employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return repo.findById(id);
	}
	@PostMapping("/employees/{id}")
	public String addEmployee(@PathVariable int id,@RequestBody Employee e ) {
		if(repo.existsById(id)) return "Employee already exists";
		if(e.getEid() != id) return "Id does not match";
		repo.save(e);
		
		return "Employee saved successfully";
		
	}
	@PutMapping(path="/employees/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Employee e) {
		if(!repo.existsById(id)) return "Employee does not exists";
		if(e.getEid() != id) return "Id does not match";
		repo.save(e);
		return "Employee updated successfully";
	}
	@GetMapping("/employees/find/designation")
	public List<Employee> findByDesignation(String designation) {
		return repo.findByDesignation(designation);
	}
	@GetMapping("/employees/find/salary")
	public List<Employee> findBySalary(int salary) {
		return repo.findBySalaryLessThan(salary);
	}
	@GetMapping("/employees/find/custom")
	public List<Employee> findByCustom(String designation){
		return repo.myCustomQuery(designation);
	}*/
	
}
