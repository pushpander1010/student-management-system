package com.register.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.register.models.Student;
import com.register.services.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/")
	public String getStudents(Model model) {
		List<Student> students = this.studentService.getAllStudents();
		model.addAttribute("students", students);
		model.addAttribute("isHomePage", true);
		return "home";
	}

	@GetMapping("/createStudent")
	public String getCreateStudentPage(Model model) {
		Student student = new Student();
		model.addAttribute(student);
		return "createStudent";
	}

	@PostMapping("/create")
	public String createStudent(@ModelAttribute("student") Student student) {
		this.studentService.createStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable  int id) {
		this.studentService.deleteStudent(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable int id,Model model) {
		Student student=this.studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "updateStudent";
	}
	
	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute Student student, Model model) {
		this.studentService.editStudent(id,student);
		return "redirect:/";
	}
}
