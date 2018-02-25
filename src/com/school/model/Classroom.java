package com.school.model;

import java.util.List;

public class Classroom {
	private int standard;
	private char section;
	private List<Student> students;
	private List<Subject> subjects;
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public List<Student> getStudents() {
		return students;
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	
}
