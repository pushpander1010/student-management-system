package com.register.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.register.models.Student;
import com.register.repositories.StudentRepo;
import com.register.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepo studentRepo;
	
	
	
	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}



	@Override
	public List<Student> getAllStudents() {
		return this.studentRepo.findAll();
	}



	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method student
		return this.studentRepo.save(student);
	}



	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student student=this.studentRepo.findById(id).orElseThrow();
		this.studentRepo.delete(student);
	}



	@Override
	public Student editStudent(int id, Student student) {
		// TODO Auto-generated method stub
		Student existingStudent=this.studentRepo.findById(id).orElseThrow();
		existingStudent.setFirst_name(student.getFirst_name());
		existingStudent.setLast_name(student.getLast_name());
		existingStudent.setStd(student.getStd());
		existingStudent.setPercentage(student.getPercentage());
		this.studentRepo.save(existingStudent);
		return existingStudent;
	}



	@Override
	public Student getStudentById(int id) {
		Student student=this.studentRepo.findById(id).orElseThrow();
		return student;
	}
}
