package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentDao;
import com.prowings.entity.Student;
import com.prowings.exception.InvalidStudentException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public boolean saveStudent(Student std) {

		System.out.println("inside StudentService :: saveStudent()");

		if(validStudent(std))
			return studentDao.saveStudent(std);
		else
			return false;
	}

	private boolean validStudent(Student std) {

		if(std.getName().length() >= 3)
			return true;
		else
			throw new InvalidStudentException("invalid name");
	}

	@Override
	public List<Student> getAllStudents() {

		System.out.println("inside StudentService :: getAllStudents()");
		
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		
		System.out.println("inside StudentService :: getStudentById()");
		
		return studentDao.getStudentById(id);
	}

	@Override
	public List<Student> findByCity(String city) {
		
		System.out.println("inside StudentService :: findByCity()");
		
		return studentDao.findByCity(city);
	}

	@Override
	public List<Student> sortStudent(String field) {
		
		System.out.println("inside StuddentService :: sortStudent()");
		
		return studentDao.sortStudent(field);
	}

	@Override
	public boolean deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}

	@Override
	public boolean updateStudent(Student student) {
		
		System.out.println("inside StudentService :: saveStudent()");
		
		return studentDao.updateStudent(student);
	}

	

}
