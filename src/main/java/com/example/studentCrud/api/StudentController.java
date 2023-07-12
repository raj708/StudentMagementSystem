package com.example.studentCrud.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentCrud.entity.Student;
import com.example.studentCrud.services.StudentServices;

@RestController
@RequestMapping("/stud")
public class StudentController {
	StudentServices ss;

	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}

	@PostMapping
	public String addStudent(@RequestBody Student s) {
		String msg=ss.addStudent(s);
		return msg;
	}
	@GetMapping(value="{kodId}")
	public Student getStudent(@PathVariable("kodId") String kodId) {
		Student s=ss.getStudent(kodId);
		return s;
	}
	@GetMapping(value="/a")
	public List<Student> getAllStudent(){
		List<Student> slist=ss.getAllStudent();
		return slist;
	}
	@PutMapping
	public String updateStudent(@RequestBody Student s) {
		String msg=ss.updateStudent(s);
		return msg;
	}
	@DeleteMapping(value="{kodId}")
	public String deleteStudent(@PathVariable("kodId") String kodId) {
		String msg=ss.deleteStudent(kodId);
		return msg;
		
	}

}
