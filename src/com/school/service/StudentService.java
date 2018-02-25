package com.school.service;

import java.util.Date;
import java.util.Iterator;
import com.school.model.Student;

public interface StudentService {
	
	String register(String name, Date dob, int standard, char section);
	
	Student find(String registrationNumber);
	
	void updateMarks(String registrationNumber, String subjectCode, int marks);
	
	Iterator<Student> getAll();
	
}
