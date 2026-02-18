package com.example.demo.repo.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface PostgresStudentRepo extends JpaRepository<Student,Integer>{

}
