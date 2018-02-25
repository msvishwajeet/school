package com.school.model;

import java.util.Date;
import java.util.List;

public class Teacher {
	private String name;
	private Date dob;
	private Date addmissionDate;
	private String registrationId;
	private List<Subject> subjects;
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
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
