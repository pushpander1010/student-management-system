package com.register.services;

import java.util.List;

import com.register.models.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public Student createStudent(Student student);
	public void deleteStudent(int id);
	public Student editStudent(int id, Student student);
	public Student getStudentById(int id);
}
