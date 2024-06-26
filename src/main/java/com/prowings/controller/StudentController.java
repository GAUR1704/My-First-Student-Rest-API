package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {

		System.out.println("request received to save the student to DB!!");
		System.out.println("Incoming student object : " + student);

		boolean res = studentService.saveStudent(student);

		if (res)
			return new ResponseEntity<String>("Student saved successfully!!!", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Error while saving the Student!!!", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/students")
	public List<Student> getAllstudents() {

		System.out.println("request received to fetch Students from DB!!");

		return studentService.getAllStudents();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {

		System.out.println("request received to fetch Student of id: " + id + "from DB!!");

		HttpHeaders headers = new HttpHeaders();
		headers.add("my header", "myHeaderValue");
		headers.add("aaaa", "bbbb");

		return new ResponseEntity<Student>(studentService.getStudentById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/students/search")
	public List<Student> getALlStudentsSerchBy(@RequestParam("city") String city) {

		System.out.println("request received to fetch all Students from city : " + city);

		return studentService.findByCity(city);
	}

	@GetMapping("/students/sort")
	public List<Student> sortStudent(@RequestParam("field") String field) {

		System.out.println("Inside sortStudent() of StudentController");

		return studentService.sortStudent(field);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable int id) {

		System.out.println("request received to delete Student of id: " + id + "from DB!!");

		return studentService.deleteStudentById(id)
				? 
				new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK)
				: new ResponseEntity<String>("Failed to delete", HttpStatus.BAD_REQUEST);
//		if (studentService.deleteStudentById(id))
//
//			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("Failed to delete", HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/students")
	public String updateStudent(@RequestBody Student student) {
		System.out.println("request received to update the student");
		System.out.println("Incoming student object : " + student);
		boolean res = studentService.updateStudent(student);
		if (res)
			return "Student updated successfully!!!";
		else
			return "Error while updating the Student!!!";
	}

//	@ExceptionHandler(StudentNotFoundException.class)
//	public ResponseEntity<MyCustomError> handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
//		
//		MyCustomError error = new MyCustomError();
//		error.setMassage(ex.getMessage());
//		error.setRootCause("abc");
//		error.setStatus(404);
//		
//		return new ResponseEntity<MyCustomError>(error, HttpStatus.NOT_FOUND);
//	}
}
