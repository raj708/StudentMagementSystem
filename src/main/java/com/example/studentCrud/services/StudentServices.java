package com.example.studentCrud.services;

import java.util.List;

import com.example.studentCrud.entity.Student;

public interface StudentServices {
	String addStudent(Student s);
	Student getStudent(String kodId);
	List<Student> getAllStudent();
	String updateStudent(Student s);
	String deleteStudent(String kodId);

}
