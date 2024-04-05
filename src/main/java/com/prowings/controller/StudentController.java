package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public String saveStudent(@RequestBody Student student) {

		System.out.println("request received to save the student to DB!!");
		System.out.println("Incoming student object : " + student);

		boolean res = studentService.saveStudent(student);

		if (res)
			return "Student saved successfully!!!";
		else
			return "Error while saving the Student!!!";

	}

	@GetMapping("/students")
	public List<Student> getAllstudents() {

		return studentService.getAllStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {

		System.out.println("Inside getAllstudentById() of StudentController");

		return studentService.getStudentById(id);
	}

	@GetMapping("/students/search")
	public List<Student> getALlStudentsSerchBy(@RequestParam("city") String city) {

		System.out.println("request received to fetch all Students from city : " + city);

		return studentService.findByCity(city);
	}
	
	@GetMapping("/students/sort")
	public List<Student> sortStudent(@RequestParam("field") String field){
		
		System.out.println("Inside sortStudent() of StudentController");
		
		return studentService.sortStudent(field);
	}
	
	@DeleteMapping("/students/{id}")
	public boolean deleteStudentById(@PathVariable int id) {
		
		System.out.println("Inside deleteStudentById() of StudentController");
		
		return studentService.deleteStudentById(id);
		
	}
	
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student student)
	{
		System.out.println("request received to update the student");
		System.out.println("Incoming student object : "+student);
		boolean res = studentService.updateStudent(student);
		if (res)
			return "Student updated successfully!!!";
		else
			return "Error while updating the Student!!!";
	}
}
