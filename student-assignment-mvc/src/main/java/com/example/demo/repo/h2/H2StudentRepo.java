package com.example.demo.repo.h2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface H2StudentRepo extends JpaRepository<Student,Integer>{

}
