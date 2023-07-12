package com.example.studentCrud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentCrud.entity.Student;
import com.example.studentCrud.repository.StudentRepository;
@Service
public class StudentServiceImplementation implements StudentServices {
	StudentRepository srepo;

	public StudentServiceImplementation(StudentRepository srepo) {
		super();
		this.srepo = srepo;
	}

	public String addStudent(Student s) {
		srepo.save(s);
		return "Student added";
	}

	public Student getStudent(String kodId) {
		Student st=srepo.findById(kodId).get();
		return st;
	}

	public List<Student> getAllStudent() {
		List<Student> slist=srepo.findAll();
		return slist;
	}

	public String updateStudent(Student s) {
		srepo.save(s);
		return "Student updated";
	}

	public String deleteStudent(String kodId) {
		srepo.deleteById(kodId);;
		return "Student deleted successfully !";
	}
	
	

}
