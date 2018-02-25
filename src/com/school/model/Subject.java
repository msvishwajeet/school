package com.school.model;

public class Subject {
	private String code;
	private String name;
	private Teacher teacher;
	private int standard;
	private int maxMarks;
	public String getCode() {
		return code;
	}
	public void setCode(String code2) {
		this.code = code2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
}
