package com.register.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.models.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
