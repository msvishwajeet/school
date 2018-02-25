package com.school.service;

import java.util.List;

import com.school.model.Subject;

public interface SubjectService {

	List<Subject> getByStandard(int standard);

	void registerSubject(String name, String teacherreg, int standard);
	
}
