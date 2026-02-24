package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmpRepo;
@Service
public class EmployeeService {
	@Autowired
	EmpRepo repo;
	public Optional<Employee> findEmpById(int id){
		Optional<Employee> emp = repo.findById(id);
		if(emp.isEmpty()) {
			throw new ResponseStatusException(
			        HttpStatusCode.valueOf(204),
			        "Invalid Employee id"
			);
		}
		else return emp;
	}
}
