package com.school.service;

import java.util.List;

import com.school.model.Classroom;

public interface ClassroomService {
	
	Classroom find(int standard, char section);
	String createClass(int standard, char section);
	List<Classroom> find(int standard);
}
