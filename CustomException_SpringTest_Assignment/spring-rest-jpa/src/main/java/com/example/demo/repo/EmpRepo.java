package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer>{
	public List<Employee> findByDesignation(String designation);
	public List<Employee> findByAgeGreaterThan(int age);
	public List<Employee> findBySalaryLessThan(int salary);
	
	@Query("from Employee where designation = ?1")
	public List<Employee> myCustomQuery(String designation);
}
