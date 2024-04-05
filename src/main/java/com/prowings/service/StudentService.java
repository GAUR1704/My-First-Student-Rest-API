package com.prowings.service;

import java.util.List;

import com.prowings.entity.Student;

public interface StudentService {
	
	public boolean saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(int id);

	public List<Student> findByCity(String city);

	public List<Student> sortStudent(String field);

	public boolean deleteStudentById(int id);

	public boolean updateStudent(Student student);

}
