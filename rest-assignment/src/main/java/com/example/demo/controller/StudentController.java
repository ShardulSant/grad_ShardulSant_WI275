package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo repo;
	
	@GetMapping("/student")
	public List<Student> getStudents(){
		return repo.findAll();
	}
	@GetMapping("/student/RegNo")
	public Optional<Student> getRegNo(int regNo) {
		return repo.findById(regNo);
	}
	@PostMapping("/student")
	public String insertStudent(@RequestBody Student s) {
		if(repo.existsById(s.getRegNo())) return "Student already exists";
		repo.save(s);
		return "Student has been saved";
	}
	@PutMapping("/student/regNo")
	public String updateStudent(@RequestBody Student s,@RequestParam int regNo) {
		if(!repo.existsById(s.getRegNo())) return "Student does not exists";
		else if(s.getRegNo() != regNo) return "Registration no does not match";
		repo.save(s);
		return "Student has been updated";
	}
	@PatchMapping("/student/regNo")
	public String updateStudentByRegNo(@RequestBody Student s,@RequestParam int regNo) {
		if(!repo.existsById(s.getRegNo())) return "Student does not exist";
		else if(s.getRegNo() != regNo) return "Registration no does not match";
		Optional<Student> s1 = repo.findById(regNo);
		if(s.getName() == null)s.setName(s1.get().getName());
		if(s.getRollno() == 0)s.setRollno(s1.get().getRollno());
		if(s.getGender()== null)s.setGender(s1.get().getGender());
		if(s.getPercentage() == 0)s.setPercentage(s1.get().getPercentage());
		if(s.getStandard() == 0)s.setStandard(s1.get().getStandard());
		if(s.getSchool() == null)s.setSchool(s1.get().getSchool());
		repo.save(s);
		return "Student has been updated";
	}
	@DeleteMapping("/student/regNo")
	public String deleteStudent(@RequestParam int regNo) {
		if(!repo.existsById(regNo))return "Student does not exists";
		repo.deleteById(regNo);
		return "Student deleted successfully";
	}
	@GetMapping("/student/school")
	public List<Student> getStudentsBySchool(@RequestParam String school){
		return repo.findBySchool(school);
	}
	@GetMapping("/student/school/count")
	public int getCountBySchool(@RequestParam String school){
		return repo.findBySchool(school).size();
	}
	@GetMapping("/student/school/standard/count")
	public int getCountByStandard(@RequestParam int standard) {
		return repo.findByStandard(standard).size();
	}
	@GetMapping("/student/result")
	public List<Student> getStudentResult(String res) {
		if(res.equals("Pass")) {
			return repo.getStudentAbove();
		}
		else
			return repo.getStudentBelow();
	}
	@GetMapping("/student/strength")
	public int getStudentStrength(String gender,int standard){
		return repo.getStudentStrength(gender,standard).size();
	}
}
