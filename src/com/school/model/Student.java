package com.school.model;
import java.util.Date;
import java.util.Map;

public class Student {
	private String name;
	private Date dob;
	private Date addmissionDate;
	private Classroom classroom;
	private String registrationId;
	private Map<String, Integer> marks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getAddmissionDate() {
		return addmissionDate;
	}
	public void setAddmissionDate(Date addmissionDate) {
		this.addmissionDate = addmissionDate;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public Map<String, Integer> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}
	
}
