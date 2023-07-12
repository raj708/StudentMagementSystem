package com.example.studentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentCrud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
