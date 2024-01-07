package com.register.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SNo")
	private int id;
	@Column(name = "First Name", nullable = false)
	private String first_name;
	@Column(name = "Last Name")
	private String last_name;
	@Column(name = "Class")
	private int std;
	@Column(name = "Percentage")
	private float percentage;
}
