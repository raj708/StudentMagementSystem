package com.example.studentCrud.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studentCrud.entity.Student;
import com.example.studentCrud.services.StudentServices;

@Controller
public class StudentMappingController {
	StudentServices ss;

	public StudentMappingController(StudentServices ss) {
		super();
		this.ss = ss;
	}
	//addStudent.html page view
    @GetMapping("/addStudent")
	public String viewAddStudentPage() {
		return "AddStudent";
		
	}
    //udateStudent.html page view
    @GetMapping("/updateStudent")
	public String viewUdateStudentPage() {
		return "UpdateStudent";
		
	}
  //viewDetail.html page view
    @GetMapping("/viewDetails")
	public String viewDetailPage() {
		return "viewDetail";		
	}
    
//    //ShowDetail.html page view
//    @GetMapping("/showDetails")
//	public String showDetailPage() {
//		return "showDetails";		
//	}
    //add data to database
    @PostMapping("/addStud")
	public String addStudent(@RequestParam("roll") String kodId,@RequestParam("name") String name,@RequestParam("branch") String branch) {
		Student s=new Student(kodId,name,branch);
		ss.addStudent(s);
		return "index";
	}
    //update data to database
    @PutMapping("/udateStud")
	public String updateStudent(@RequestParam("roll") String kodId,@RequestParam("name") String name,@RequestParam("branch") String branch) {
		Student st=ss.getStudent(kodId);
		st.setName(name);
		st.setBranch(branch);
		ss.updateStudent(st);
		return "index";
	}
    @GetMapping("/getStud")
    public String getStudent(@RequestParam("roll") String kodId,Model model) {
    	Student st=ss.getStudent(kodId);
    	model.addAttribute("student",st);
    	System.out.println(model);
    	return "showDetails";
    }

}
