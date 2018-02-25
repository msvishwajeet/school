package com.school.service;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.school.model.Teacher;

public class TeacherServiceImpl implements TeacherService {
	private Map<String, Teacher> tMap=new HashMap<>();
	private int counter=101;
	@Override
	public String register(String name, Date dob) {
		Teacher t=new Teacher();
		t.setDob(dob);
		t.setName(name);
		t.setSubjects(new ArrayList<>());
		String registrationId = String.valueOf(Calendar.getInstance().getWeekYear())+"-"+counter++;
		t.setRegistrationId(registrationId);
		Date addmissionDate=new Date();
		t.setAddmissionDate(addmissionDate);
		tMap.put(registrationId, t);
		return registrationId;
	}

	@Override
	public Teacher find(String regNumber) {
		return tMap.get(regNumber);
	}

	@Override
	public Iterator<Teacher> getAll() {
		
		return tMap.values().iterator();
	}
	
}
