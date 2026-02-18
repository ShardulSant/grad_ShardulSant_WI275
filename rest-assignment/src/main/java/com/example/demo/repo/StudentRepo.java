package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
	
	public List<Student> findBySchool(String school);
	public List<Student> findByStandard(int standard);
	
	
	@Query("from Student where percentage > 40 Order by percentage desc")
	public List<Student> getStudentAbove();
	
	@Query("from Student where percentage < 40 order by percentage desc")
	public List<Student> getStudentBelow();
	@Query("from Student where gender = ?1 and standard = ?2")
	public List<Student> getStudentStrength(String gender,int standard);
}
